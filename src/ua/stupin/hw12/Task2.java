package ua.stupin.hw12;

/*
 * Создайте класс с двумя методами f( ) и g( ). В g( ) выбросите исключение 1.
 * В f( ) вызовите g( ), поймайте его исключение и, в блдоке catch, выбросите другое исключение 2.
 * Проверьте ваш код в main( ).
 */
public class Task2 {
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

    static int addNumber(int number) throws FirstUserExceptions {
        if (number == 0) {
            throw new FirstUserExceptions("Number can't be 0");
        }
        return number + number;
    }

    static int multiplicationNumber(int number) throws SecondUserExceptions {
        try {
            addNumber(number);
        } catch (FirstUserExceptions exceptions) {
            exceptions.printStackTrace();
        }
        if (number >= 1073741824 ) {
            throw new SecondUserExceptions("Number is too large for integer");
        }
        return Math.abs(number * number);

    }

    public static void main(String[] args) {
        Task2 addNumber = new Task2();
        Task2 multiplicationNumber = new Task2();
        try {
            System.out.println(addNumber.addNumber(5));
        } catch (FirstUserExceptions exceptions){
            exceptions.printStackTrace();
            System.out.println("Exception 1 is caught");
        }
        try {
            System.out.println(multiplicationNumber.multiplicationNumber(1073741823));
        } catch (SecondUserExceptions exception) {
            exception.printStackTrace();
            exception.getMessage();
            System.out.println("Exception 2 is caught");
        }
    }
}