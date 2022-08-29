package lesson1.invoice;

public class InvoiceItem {
    private String partNumber;
    private String description;
    private int count;
    private double unitPrice;


    public InvoiceItem(String partNumber, String description, int count, double unitPrice) {
        this.partNumber = partNumber;
        this.description = description;
        this.count = count;
        this.unitPrice = unitPrice;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "InvoiceItem{" +
                "partNumber='" + partNumber + '\'' +
                ", description='" + description + '\'' +
                ", count=" + count +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
