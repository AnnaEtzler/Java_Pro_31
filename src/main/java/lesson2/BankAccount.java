package lesson2;

public class BankAccount {
    private String id;
    private String name;
    private int balance;

    public BankAccount(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int money){
        return this.balance += money;
    }

    public int debet(int amounte){
        if(amounte <= balance){
            this.balance -= amounte;
            return this.balance;

        } else {
            System.out.println("error");

        }
        return balance;

    }

    public int transfer(BankAccount bankAccount, int amount){
        if (amount <= balance){
            this.balance -= amount;
            bankAccount.setBalance(bankAccount.getBalance()+amount);
            return this.balance;
        }
        else {
            return this.balance;
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("24","ara",300);
        account.credit(60);
        System.out.println(account.toString());
        account.debet(50);
        System.out.println(account.toString());
        account.credit(600);
        System.out.println(account.toString());
        BankAccount account1 = new BankAccount("567","pipa", 500);
        account.transfer(account1, 500);
        System.out.println(account1.toString());
        System.out.println(account.toString());
    }
}
