package kevserbusrayildirim.patikaodev2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class PatikaOdev2Application {

    public static void main(String[] args) {
        // Müşteri listesi oluşturma
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Ali Can", LocalDate.of(2023, 6, 10), "Sağlık"));
        customers.add(new Customer("Ayşe Yılmaz", LocalDate.of(2023, 6, 15), "İnşaat"));
        customers.add(new Customer("Mehmet Demir", LocalDate.of(2024, 3, 1), "Eğitim"));

        // Faturaların oluşturulması ve müşterilere eklenmesi

        customers.get(0).addInvoice(new Invoice(60));
        customers.get(0).addInvoice(new Invoice(45));
        customers.get(0).addInvoice(new Invoice(55));
        customers.get(0).addInvoice(new Invoice(100));
        customers.get(1).addInvoice(new Invoice(1500));
        customers.get(2).addInvoice(new Invoice(3000));
        customers.get(1).addInvoice(new Invoice(1500));
        customers.get(1).addInvoice(new Invoice(465));
        customers.get(1).addInvoice(new Invoice(1200));
        customers.get(1).addInvoice(new Invoice(1400));


        // Tüm müşterileri listeleme
        System.out.println("Tüm müşteriler:");
        for (Customer customer : customers) {
            System.out.println(customer.getName());
        }

        // İçerisinde 'C' harfi olan müşterileri listeleme
        System.out.println("\nİçerisinde 'C' harfi olan müşteriler:");
        for (Customer customer : customers) {
            if (customer.getName().contains("C")) {
                System.out.println(customer.getName());
            }
        }

        // Haziran ayında kayıt olan müşterilerin faturalarının toplam tutarı
        int juneTotalInvoices = 0;
        for (Customer customer : customers) {
            if (customer.getRegistrationDate().getMonthValue() == 6) {
                for (Invoice invoice : customer.getInvoices()) {
                    juneTotalInvoices += invoice.getAmount();
                }
            }
        }
        System.out.println("\nHaziran ayında kayıt olan müşterilerin toplam fatura tutarı: " + juneTotalInvoices);

        // Sistemdeki tüm faturaları listeleme
        System.out.println("\nSistemdeki tüm faturalar:");
        for (Customer customer : customers) {
            for (Invoice invoice : customer.getInvoices()) {
                System.out.println(invoice.getAmount());
            }
        }

        // Sistemdeki 1500 TL üstündeki faturaları listeleme
        System.out.println("\nSistemdeki 1500 TL üstündeki faturalar:");
        for (Customer customer : customers) {
            for (Invoice invoice : customer.getInvoices()) {
                if (invoice.getAmount() > 1500) {
                    System.out.println(invoice.getAmount());
                }
            }
        }

        // Sistemdeki 1500 TL üstündeki faturaların ortalaması
        int sumOver1500 = 0;
        int countOver1500 = 0;
        for (Customer customer : customers) {
            for (Invoice invoice : customer.getInvoices()) {
                if (invoice.getAmount() > 1500) {
                    sumOver1500 += invoice.getAmount();
                    countOver1500++;
                }
            }
        }
        double averageOver1500 = (countOver1500 > 0) ? (double) sumOver1500 / countOver1500 : 0;
        System.out.println("\nSistemdeki 1500 TL üstündeki faturaların ortalaması: " + averageOver1500);

        // Sistemdeki 500 TL altındaki faturalara sahip müşterilerin isimlerini listeleme
        System.out.println("\n500 TL altındaki faturalara sahip müşteriler:");
        for (Customer customer : customers) {
            boolean hasInvoiceUnder500 = false;
            for (Invoice invoice : customer.getInvoices()) {
                if (invoice.getAmount() < 500) {
                    hasInvoiceUnder500 = true;
                    break;
                }
            }
            if (hasInvoiceUnder500) {
                System.out.println(customer.getName());
            }
        }

        // Haziran ayindaki faturalarin ortalamasi 750 TL altı olan müşterilerin hangi sektörde olduğunu listeleme
        System.out.println("\nHaziran ayında faturalarının ortalaması 750 TL altı olan müşterilerin sektörleri:");
        for (Customer customer : customers) {
            if (customer.getRegistrationDate().getMonthValue() == 6) {
                int sumInvoices = 0;
                for (Invoice invoice : customer.getInvoices()) {
                    sumInvoices += invoice.getAmount();
                }
                double averageInvoice = (double) sumInvoices / customer.getInvoices().size();
                if (averageInvoice < 750) {
                    System.out.println("Müşteri: " + customer.getName() + ", Sektör: " + customer.getSector());
                }
            }
        }

    }
}
