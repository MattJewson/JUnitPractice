public class BankAccount {
    private double balance;
    private double minimumBalance;
    private Boolean isActive;
    private String accountHolderName;



    public BankAccount(double balance, double minimumBalance){
        this.balance=balance;
        this.minimumBalance=minimumBalance;
        this.isActive = true;

    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    public double withdraw(double amount){
        if(balance -amount > minimumBalance) {
            balance -= amount;
            return amount;
        }
        else{
            throw new RuntimeException();
            }
    }

    public double deposit(double amount){
        return balance += amount;
    }
}
