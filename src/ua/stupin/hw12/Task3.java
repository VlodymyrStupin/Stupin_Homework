package ua.stupin.hw12;
/*
* Создайте три новых типа исключений. Напишите класс с методом, который выбрасывает все три исключения.
* В main( ) вызовите метод, но используйте только единственное предложение catch,
* которое будет ловить все три вида исключений.
 */
public class Task3 {
    static class FirstUserException extends Exception {
        public FirstUserException(String message) {

            super(message);
        }
    }
    static class SecondUserException extends Exception {
        public SecondUserException(String message) {

            super(message);
        }
    }
    static class ThirdUserException extends Exception {
        public ThirdUserException(String message) {

            super(message);
        }
    }
    private static String doAction(String word)
            throws FirstUserException, SecondUserException, ThirdUserException {
        if (word.equals("a")) {
            throw new FirstUserException("Word can't be a one letter");
        }
        if (word.equals(" ")) {
            throw new SecondUserException("Word can't be empty space");
        }
        if (word.equals("")) {
            throw new ThirdUserException("Word can't contain nothing");
        }
        return "The word is " + word;
    }

    public static void main(String[] args) {
        try {
            doAction("a");
        } catch (FirstUserException | SecondUserException | ThirdUserException exception){
            System.out.println(exception.getMessage());
        }
    }
}
