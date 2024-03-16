package kevserbusrayildirim.patikaodev2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final LocalDate registrationDate;
    private final String sector;
    private final List<Invoice> invoices;

    // Constructor
    public Customer(String name, LocalDate registrationDate, String sector) {
        this.name = name;
        this.registrationDate = registrationDate;
        this.sector = sector;
        this.invoices = new ArrayList<>();
    }

    // Getter metotları
    public String getName() {
        return name;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getSector() {
        return sector;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    // Fatura metodu
    public void addInvoice(Invoice invoice) {
        this.invoices.add(invoice);
    }
}
