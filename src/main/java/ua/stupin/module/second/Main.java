package ua.stupin.module.second;

import org.apache.commons.collections4.map.LinkedMap;
import ua.stupin.module.second.classModels.Customer;
import ua.stupin.module.second.classModels.Invoice;
import ua.stupin.module.second.services.PersonService;
import ua.stupin.module.second.services.ShopService;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileNameForRead = "src\\main\\resources\\articles.csv";
        String fileNameForWrite = "src\\main\\resources\\invoices.csv";
        int limitOfCost = (int) (Math.random() * 10000);
        ShopService shopService = new ShopService();
        PersonService personService = new PersonService();
        Invoice invoice = new Invoice();
        List<Customer> customerList = new ArrayList<>();
        List<Integer> sumOfInvoicesList = new ArrayList<>();
        List<String> listOfTypes = new ArrayList<>();
        Map<Customer, Invoice> invoiceMap = new LinkedMap<>();
        List<Invoice> invoiceList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            customerList.add(personService.randomCustomer());
            invoice.setInvoiceList(shopService.createInvoiceFromFile(fileNameForRead));
            invoice.setCustomer(customerList.get(i));
            invoiceList.add(invoice);
            listOfTypes.add(invoice.setType(limitOfCost));
            shopService.writeToNewFile(invoice, customerList.get(i), fileNameForWrite);
            shopService.setListOfInvoices(invoice.getInvoiceList());
            sumOfInvoicesList.add(invoice.sumOfInvoice());
            invoiceMap.put(customerList.get(0), invoiceList.get(0));
        }
//  Количество проданных товаров по категориям (Telephone/Television)
        System.out.println("Sold telephones: " + getStatisticSaleTelephones(shopService));
        System.out.println("Sold televisions: " + getStatisticSaleTVs(shopService));
//  Сумма самого маленького чека и информацию о покупателе
        System.out.println("Sum of lowest invoice: " + getLowestInvoice(sumOfInvoicesList));
        System.out.println("Customer with lowest check: "
                + getCustomerWithLowestInvoice(customerList, sumOfInvoicesList));
//  Сумма всех покупок
        System.out.println("Sum of all invoices: " + getSumOfAllInvoices(sumOfInvoicesList));
//  Количество чеков с категорией retail
        System.out.println("Quantity of invoice with type retail: "
                + getQuantityOfInvoiceWithTypeRetail(listOfTypes));
//  Чеки которые содержат только один тип товара
        System.out.println("Invoices contain one type of article: ");
        printInvoiceContainedOneTypeOfArticle(shopService);
//  Первые три чека сделанные покупателями
        System.out.println("First three invoices: ");
        firstThreeInvoices(shopService);
//  Информация по чекам купленных пользователем младше 18 лет
        System.out.println("Information about invoices for customers younger then 18: ");
        getInformationAboutCustomersYoungerThenEighteen(customerList, shopService);
//  Метод который сортирует (любым известным способом) все заказы в следующем порядке
        // Сначала по возрасту покупателя от большего к меньшему
        // Далее по количеству купленных предметов
        // Далее по общей сумме купленных предметов:getAge)
        System.out.println("customer list map " + invoiceMap);
        Map<Customer, Invoice> sortedMap = invoiceMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Customer::getAge)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("Sorted list map " + sortedMap);
    }

    private static void getInformationAboutCustomersYoungerThenEighteen(List<Customer> customerList, ShopService shopService) {
        for (int i = 0; i < shopService.getListOfInvoices().size(); i++) {
            if (customerList.get(i).getAge() < 18) {
                System.out.println(shopService.getListOfInvoices().get(i));
            }
        }
    }

    private static void firstThreeInvoices(ShopService shopService) {
        System.out.println(shopService.getListOfInvoices().get(0));
        System.out.println(shopService.getListOfInvoices().get(1));
        System.out.println(shopService.getListOfInvoices().get(2));
    }

    private static int getStatisticSaleTVs(ShopService shopService) {
        int statisticSaleTVs = 0;
        for (int i = 0; i < shopService.getListOfInvoices().size(); i++) {
            for (int j = 0; j < shopService.getListOfInvoices().get(i).size(); j++) {
                if (shopService.getListOfInvoices().get(i).get(j).getType().equals("Telephone")) {
                    statisticSaleTVs++;
                }
            }
        }
        return statisticSaleTVs;
    }

    private static int getStatisticSaleTelephones(ShopService shopService) {
        int statisticSaleTelephones = 0;
        for (int i = 0; i < shopService.getListOfInvoices().size(); i++) {
            for (int j = 0; j < shopService.getListOfInvoices().get(i).size(); j++) {
                if (shopService.getListOfInvoices().get(i).get(j).getType().equals("Television")) {
                    statisticSaleTelephones++;
                }
            }
        }
        return statisticSaleTelephones;
    }

    private static void printInvoiceContainedOneTypeOfArticle(ShopService shopService) {
        boolean allEqual = true;
        for (int i = 0; i < shopService.getListOfInvoices().size(); i++) {
            for (int j = 0; j < shopService.getListOfInvoices().get(i).size() - 1; j++) {
                if (!shopService.getListOfInvoices().get(i).get(0).getType().equals(
                        shopService.getListOfInvoices().get(i).get(j + 1).getType())) {
                    allEqual = false;
                    break;
                } else {
                    allEqual = true;
                }
            }
            if (allEqual) {
                System.out.println(shopService.getListOfInvoices().get(i));
            } else if (shopService.getListOfInvoices().get(i).size() == 1) {
                System.out.println(shopService.getListOfInvoices().get(i));
            }
        }
    }

    private static int getQuantityOfInvoiceWithTypeRetail(List<String> listOfTypes) {
        return listOfTypes.stream()
                .filter(it -> it.equals("retail"))
                .toList()
                .size();
    }

    private static int getSumOfAllInvoices(List<Integer> sumOfInvoices) {
        return sumOfInvoices.stream()
                .reduce(0, Integer::sum);
    }

    private static int getLowestInvoice(List<Integer> sumOfInvoices) {
        return sumOfInvoices.stream()
                .mapToInt(it -> it)
                .min().orElseThrow(NoSuchElementException::new);
    }

    private static Customer getCustomerWithLowestInvoice(List<Customer> customerList, List<Integer> listSumOfInvoices) {
        for (int i = 0; i < listSumOfInvoices.size(); i++) {
            if (getLowestInvoice(listSumOfInvoices) == listSumOfInvoices.get(i)) {
                return customerList.get(i);
            }
        }
        return null;
    }
}
