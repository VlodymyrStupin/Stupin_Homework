package ua.stupin.hw12;

import java.util.Optional;

// Реализовать метод поиска индекса телефона в массиве, если телефона нет - вернуть пустой Optional.
public class Task4 {
    static class PhoneBook {
        private static final String[] PHONE_BOOK = new String[3];

        public static void main(String[] args) {
            PHONE_BOOK[0] = "016/161616";
            PHONE_BOOK[1] = "016/161617";
            PHONE_BOOK[2] = "016/161618";
            System.out.println(findIndexByPhoneNumber("016/161619"));
        }

        public static Optional<Integer> findIndexByPhoneNumber(String phoneNumber) {
            for (int i = 0; i < PHONE_BOOK.length; i++) {
                if (PHONE_BOOK[i].equals(phoneNumber)) {
                    return Optional.of(i);
                }
            }
            return Optional.empty();
        }
    }
}
