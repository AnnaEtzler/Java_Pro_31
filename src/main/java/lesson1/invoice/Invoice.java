package lesson1.invoice;

import java.util.Arrays;

public class Invoice {
    private InvoiceItem [] invoiceItems;

    public Invoice(InvoiceItem[] invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < invoiceItems.length; i++) {
            res += invoiceItems[i] + "\n";
        }
        return res;
    }

    public double calculate(){
        double d = 0;
        for (InvoiceItem i: invoiceItems){
            d += i.getUnitPrice()*i.getCount();

        }
        return d;
    }

    public static void main(String[] args) {
        InvoiceItem [] i = new InvoiceItem[]{
                new InvoiceItem("abs", "gvozdi", 30, 0.02),
                new InvoiceItem("ffki3", "molotok", 1, 5),

        };

        Invoice invoice = new Invoice(i);
        System.out.println(invoice);
        System.out.println(invoice.calculate());

    }
}
