import java.util.ArrayList;
import java.util.Scanner;

public class solution49 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        Bill[] bills = new Bill[n];
        for (int i = 0; i < bills.length; i++) {
            int a = Integer.parseInt(sc.nextLine());
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble(); sc.nextLine();
            boolean e = sc.nextBoolean(); sc.nextLine();
            bills[i] = new Bill(a, b, c, d, e);
        }
        boolean s = sc.nextBoolean(); sc.nextLine();
        String t = sc.nextLine();
        Bill[] ans = findBillWithMaxBillAmountBasedOnStatus(bills,s);
        if (ans!=null) {
            for (int i = 0; i < ans.length; i++) {
                System.out.println(ans[i].getNo()+ "#" +ans[i].getName());
            }
        }
        else System.out.println("There are no bill with the given status");
        int count = getCountWithTypeOfConnection(bills, t);
        if (count!=0) {
            System.out.println(count);
        }else System.out.println("There are no bills with given type of connection");
    }
    public static Bill[] findBillWithMaxBillAmountBasedOnStatus(Bill[] bills, boolean s){
        double max = bills[0].getAmount();
        for (int i = 0; i < bills.length; i++) {
            if (bills[i].getAmount()>max) {
                max = bills[i].getAmount();
            }
        }
        ArrayList<Bill> billList = new ArrayList<>();
        for (int i = 0; i< bills.length; i++) {
            if (bills[i].getAmount()==max && bills[i].getStatus() == s) {
                billList.add(bills[i]);
            }
        }
        if (billList.size()>0) {
            billList.sort((bill1, bill2) -> Integer.compare(bill1.getNo(), bill2.getNo()));
            return billList.toArray(new Bill[billList.size()]);
        }
        return null;
    }
    
    public static int getCountWithTypeOfConnection(Bill[] bills, String t){
        int c = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i].getConnectionType().equalsIgnoreCase(t)) {
                c++;
            }
        }
        if (c>0) {
            return c;
        }
        return 0;
    }
}

class Bill{
    private int billNo;
    private String name;
    private String typeOfConnection;
    private double billAmount;
    private boolean status;
    
    public Bill(int billNo, String name, String typeOfConnection, double billAmount, boolean status){
        this.billNo = billNo;
        this.name = name;
        this.typeOfConnection = typeOfConnection;
        this.billAmount = billAmount;
        this.status = status;
    }
    public int getNo(){
        return billNo;
    }
    public void setNo(int billNo){
        this.billNo = billNo;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getConnectionType(){
        return typeOfConnection;
    }
    public void setConnectionType(String typeOfConnection){
        this.typeOfConnection = typeOfConnection;
    }
    public double getAmount(){
        return billAmount;
    }
    public void setAmount(double billAmount){
        this.billAmount = billAmount;
    }
    public boolean getStatus(){
        return status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }
}
