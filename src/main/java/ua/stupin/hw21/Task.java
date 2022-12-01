package ua.stupin.hw21;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;

/*
Необхідно реалізувати за допомогою анотацій + рефлексії:
- анотації для отримання значень проанотованих полів (наприклад @Getter)
- можливість змінювати значення проанотованих полів ( нпаприклад @Setter)
- проста валідація проанотованих полів за їх значенням (наприклад @Validate)
 */
@Test(name = "bernard")
public class Task {
    @Setter
    @Getter
    String name;
    @Setter
    @Getter
    int number;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Task task = new Task();
        Class cl = Class.forName("ua.stupin.hw21.Task");
        task.setName("aloe");
        Field[] fields = cl.getDeclaredFields();
        for (Field field: fields) {
            System.out.println(field);
        }
        Class<? extends Task> taskClass = task.getClass();
        Field field = taskClass.getDeclaredField("name");
        String newName = (String) field.get(task);
        System.out.println(newName);



    }
}
