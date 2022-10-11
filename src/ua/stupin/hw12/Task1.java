package ua.stupin.hw12;

/*
 * Создайте класс с main( ), который выбрасывает объект класса Exception внутри блока try.
 * Передайте конструктору Exception аргумент String.
 * Поймайте исключение внутри блока catch и напечатайте аргумент String.
 * Добавьте блок finally и напечатайте сообщение, чтобы убедится, что вы были там.
 */
public class Task1 {
    static class UserInputException extends Exception {

        public UserInputException(String message) {
            super(message);
        }
    }

    private static String doAction(String word) throws UserInputException {
        if (word.equals("home")) {
            throw new UserInputException("Word can't be home");
        }
        return "The word is " + word;
    }

    public static void main(String[] args) {
        try {
            doAction("home");
        } catch (UserInputException exception) {
            System.out.println(exception.getMessage());
        } finally {
            System.out.println("Exception is checked");
        }
    }


}
