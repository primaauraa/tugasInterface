package koperasi;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Payable{
    private int registrationNumber;
    private String name;
    private int salaryPerMonth;
    private List<Invoice> invoices;

    public Employee(int registrationNumber, String name, int salaryPerMonth) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = new ArrayList<>();
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    @Override
    public double getPayableAmount() {
        return salaryPerMonth - getTotalInvoicesAmount();
    }

    public double getTotalInvoicesAmount() {
        double total = 0;
        for (Invoice invoice : invoices) {
            total += invoice.getPayableAmount();
        }
        return total;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public String getName() {
        return name;
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }


}
