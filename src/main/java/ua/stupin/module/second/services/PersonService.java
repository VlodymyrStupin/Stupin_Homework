package ua.stupin.module.second.services;

import ua.stupin.module.second.classModels.Customer;

public class PersonService {
    public Customer randomCustomer() {
        int randomId = (int) (Math.random() * 1000);
        String randomMail = (int) (Math.random() * 100) + "." + (int) (Math.random() * 100) + "@gmail.com";
        int randomAge = 15 + (int) (Math.random() * 15);
        return new Customer(randomId, randomMail, randomAge);
    }
}
