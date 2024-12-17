import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class solution50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[2];
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("Account "+ (i+1)+ ":");
            System.out.print("Account Number: ");
            String a = sc.nextLine();
            System.out.print("Account Holder Name: ");
            String b = sc.nextLine();
            System.out.print("Balance: ");
            double c = sc.nextDouble(); sc.nextLine();
            accounts[i] = new BankAccount(a,b,c);
            System.out.println();
        }
        System.out.println("Transfer Details:");
        System.out.print("Ammount: ");
        double d = sc.nextDouble(); sc.nextLine();
        System.out.print("Transaction Code: ");
        String e = sc.nextLine();

        System.out.println("\nBefore Transfer:");
        int c = 1;
        for(BankAccount account: accounts){
            System.out.println("Account "+c+": " + account.getAccountHolderName() + " - " + account.getAccountNumber() + " - " + account.getBalance());
            c++;
        }
        try {
            Transaction transaction = BankUtils.transferFunds(accounts[0], accounts[1], d, e);

            // Displaying account details after transfer
            System.out.println("\nAfter Transfer:");
            int c1 = 1;
            for (BankAccount account : accounts) {
                System.out.println("Account "+c1+": " + account.getAccountHolderName() + " - " + account.getAccountNumber() + " - " + account.getBalance());
                c1++;
            }

            // Transaction details
            System.out.println("\nTransaction Details:");
            System.out.println("Transaction Code: " + transaction.getTransactionCode());
            System.out.println("Amount Transferred: " + transaction.getAmmount());
            System.out.println("Timestamp: " + transaction.getTimeStamp());

        } catch (InsufficientBalanceExeption er) {
            System.out.println(er.getMessage());
        }
    }

}

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    
    BankAccount(String accountNumber, String accountHolderName, double balance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public String getAccountHolderName(){
        return accountHolderName;
    }
    public void setDept(String accountHolderName){
        this.accountHolderName = accountHolderName;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
}

class BankUtils {
    public static Transaction transferFunds(BankAccount fromAccount, BankAccount toAccount, double amount, String transactionCode) throws InsufficientBalanceExeption{
        if (fromAccount.getBalance()<amount) {
            throw new InsufficientBalanceExeption("Insufficient balance in"+ fromAccount.getAccountHolderName() +"'s account.");
        }
        fromAccount.setBalance(fromAccount.getBalance()-amount);
        toAccount.setBalance(toAccount.getBalance()+amount);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fTimestamp = sdf.format(timestamp);
        return new Transaction(transactionCode, amount, fTimestamp);
    }
}
class Transaction{
    private String transactionCode;
    private double amount;
    private String timestamp;
    Transaction(String transactionCode, double amount, String timestamp){
        this.transactionCode = transactionCode;
        this.amount = amount;
        this.timestamp = timestamp;
    }
    public String getTransactionCode(){
        return transactionCode;
    }
    public double getAmmount(){
        return amount;
    }
    public String getTimeStamp(){
        return timestamp;
    }
}
class InsufficientBalanceExeption extends Exception{
    public InsufficientBalanceExeption(String message){
        super(message);
    }
}