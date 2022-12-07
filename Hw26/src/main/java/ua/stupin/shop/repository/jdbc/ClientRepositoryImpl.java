package ua.stupin.shop.repository.jdbc;

import lombok.SneakyThrows;
import ua.stupin.shop.entity.Client;
import ua.stupin.shop.repository.ClientRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryImpl extends AbstractJDBCRepository implements ClientRepository {
    private final String createUserSQL = "INSERT INTO clients (client_id, first_name, last_name, date_of_birth) VALUES (?,?,?,?)";
    private final String selectAllClientsSQL = "SELECT * FROM clients";
    private final String selectClientByIdSQL = "SELECT * FROM clients WHERE client_id = ?";
    private final String getClientsWithAmountOfOrdersGreater =
            "SELECT * FROM clients LEFT OUTER JOIN orders on clients.client_id " +
                    "= orders.client_id GROUP BY clients.client_id HAVING COUNT(*) > ";
    private final String removeAllClientsYoungerThan = "DELETE FROM clients WHERE (YEAR (NOW()) - YEAR(date_of_birth)< ?)";

    @SneakyThrows
    @Override
    public Client getById(String id) {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(selectClientByIdSQL)) {
            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractClientFromResultSet(resultSet);
                }
                return null;
            }
        }
    }

    @SneakyThrows
    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectAllClientsSQL)) {
            while (resultSet.next()) {
                clients.add(extractClientFromResultSet(resultSet));
            }
            return clients;
        }
    }

    @SneakyThrows
    @Override
    public void save(Client client) {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(createUserSQL)) {
            statement.setString(1, client.getId());
            statement.setString(2, client.getFirstName());
            statement.setString(3, client.getLastName());
            statement.setDate(4, Date.valueOf(client.getDateOfBirth()));
            statement.execute();
        }
    }


    private Client extractClientFromResultSet(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setId(resultSet.getString("client_id"));
        client.setFirstName(resultSet.getString("first_name"));
        client.setLastName(resultSet.getString("last_name"));
        client.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
        return client;
    }

    @SneakyThrows
    @Override
    public List<Client> getClientsWithAmountOfOrdersGreater(int amount) {
        List<Client> clientList = new ArrayList<>();
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(getClientsWithAmountOfOrdersGreater + amount)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                clientList.add(extractClientFromResultSet(resultSet));
            }
            return clientList;
        }
    }

    @SneakyThrows
    @Override
    public int removeAllClientsYoungerThan(int age) {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(removeAllClientsYoungerThan)) {
            statement.setString(1, Integer.toString(age));
            statement.execute();
        }
        return age;
    }
}