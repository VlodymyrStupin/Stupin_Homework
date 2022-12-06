package ua.stupin.module.second.services;

import com.opencsv.bean.CsvToBeanBuilder;
import ua.stupin.module.second.Article;
import ua.stupin.module.second.classModels.Customer;
import ua.stupin.module.second.classModels.Invoice;

import java.io.*;
import java.time.LocalTime;
import java.util.*;

public class ShopService {
    public List<List<Article>> listOfInvoices = new ArrayList<>();

    public List<List<Article>> getListOfInvoices() {
        return this.listOfInvoices;
    }

    public void setListOfInvoices(List<Article> listOfInvoices) {
        this.listOfInvoices.add(listOfInvoices);
    }

    public static class UserInputException extends Exception {
        public UserInputException(String message) {
            super(message);
        }
    }

    private static void checkForExceptionInFile(List<Article> listOfArticles) throws UserInputException {
        for (Article invoice : listOfArticles) {
            if (invoice.getType().equals("")
                    || invoice.getSeries().equals("")
                    || invoice.getModel().equals("")
                    || invoice.getDiagonal().equals("")
                    || invoice.getScreenType().equals("")
                    || invoice.getCountry().equals("")
                    || invoice.getPrice().equals("")) {
                throw new UserInputException("Missing data in " + invoice);
            }
        }
    }

    public List<Article> createInvoiceFromFile(String fileName) throws IOException {
        List<Article> newInvoice = new ArrayList<>();
        try {
            List<Article> listOfArticles = new CsvToBeanBuilder(new FileReader(fileName))
                    .withType(Article.class)
                    .build()
                    .parse();
            for (int i = 0; i < Math.random() * 5; i++) {
                newInvoice.add(i, listOfArticles.get((int) (Math.random() * listOfArticles.size())));
            }
            checkForExceptionInFile(newInvoice);
        } catch (IOException exception) {
            exception.getStackTrace();
        } catch (UserInputException userException) {
            userException.printStackTrace();
        }
        return newInvoice;
    }

    public void writeToNewFile(Invoice invoice, Customer customer, String fileName) throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(LocalTime.now().toString() + " ");
            writer.write(customer + " ");
            writer.write(invoice + " ");
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}