package ua.stupin.secondModuleWork.classModels;

import ua.stupin.secondModuleWork.Article;

import java.util.List;

public class Invoice {
    public List<Article> invoiceList;
    public Customer customer;
    public String type;

    public List<Article> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Article> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int sumOfInvoice() {
        int sumOfInvoice = 0;
        for (int i = 0; i < getInvoiceList().size(); i++) {
            sumOfInvoice = sumOfInvoice + Integer.parseInt(getInvoiceList().get(i).getPrice());
        }
        return sumOfInvoice;
    }

    public String setType(int limit) {
        if (sumOfInvoice() > limit) {
            return type = "wholesale";
        }
        return type = "retail";
    }

    @Override
    public String toString() {
        return "Invoice" +
                invoiceList
                + ", " + customer +
                ", type='" + type + '\'';
    }
}
