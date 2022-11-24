package lesson45;

public class Order {
    private int id;
    private int amt;
    private int cnum;
    private String odate;
    private int snum;

    public Order(int id, int amt, String odate, int cnum, int snum) {
        this.id = id;
        this.amt = amt;
        this.cnum = cnum;
        this.odate = odate;
        this.snum = snum;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    public void setOdate(String odate) {
        this.odate = odate;
    }

    public void setSnum(int snum) {
        this.snum = snum;
    }

    public int getId() {
        return id;
    }

    public int getAmt() {
        return amt;
    }

    public int getCnum() {
        return cnum;
    }

    public String getOdate() {
        return odate;
    }

    public int getSnum() {
        return snum;
    }
}
