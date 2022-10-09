package ua.stupin.hw12;
/*
* Создайте три новых типа исключений. Напишите класс с методом, который выбрасывает все три исключения.
* В main( ) вызовите метод, но используйте только единственное предложение catch,
* которое будет ловить все три вида исключений.
 */
public class Task3 {
    static class FirstUserExceptions extends Exception {
        public FirstUserExceptions(String message) {

            super(message);
        }
    }
    static class SecondUserExceptions extends Exception {
        public SecondUserExceptions(String message) {

            super(message);
        }
    }
    private static String doAction(String word)
            throws NullPointerException, FirstUserExceptions, SecondUserExceptions  {
        if (word.equals(null)) {
            throw new NullPointerException("Word can't be a curse word");
        }
        if (word.equals(" ")) {
            throw new SecondUserExceptions("Word can't be empty space");
        }
        if (word.equals("")) {
            throw new SecondUserExceptions("Word can't contain nothing");
        }
        return "The word is " + word;
    }

    public static void main(String[] args) {
        try {
            doAction(null);
        } catch (NullPointerException | FirstUserExceptions | SecondUserExceptions exception){
            exception.printStackTrace();
            exception.getMessage();
        }
    }
}
