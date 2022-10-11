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
    static class SecondUserExceptions extends Exception {
        public SecondUserExceptions(String message) {

            super(message);
        }
    }
    static class ThirdUserExceptions extends Exception {
        public ThirdUserExceptions(String message) {

            super(message);
        }
    }
    private static String doAction(String word)
            throws FirstUserException, SecondUserExceptions, ThirdUserExceptions  {
        if (word.equals("a")) {
            throw new FirstUserException("Word can't be a one letter");
        }
        if (word.equals(" ")) {
            throw new SecondUserExceptions("Word can't be empty space");
        }
        if (word.equals("")) {
            throw new ThirdUserExceptions("Word can't contain nothing");
        }
        return "The word is " + word;
    }

    public static void main(String[] args) {
        try {
            doAction("a");
        } catch (FirstUserException | SecondUserExceptions | ThirdUserExceptions exception){
            System.out.println(exception.getMessage());
        }
    }
}
