package lesson1.invoice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvoiceTest {
    @Test
    public void testInvoice(){
        InvoiceItem [] i = new InvoiceItem[]{
                new InvoiceItem("abs", "gvozdi", 30, 0.02),
                new InvoiceItem("ffki3", "molotok", 1, 5),

        };

        Invoice invoice = new Invoice(i);

        assertEquals(5.6, invoice.calculate(), 0.0001);

    }
}
