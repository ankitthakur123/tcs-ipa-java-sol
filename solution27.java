import java.util.Arrays;
import java.util.Scanner;

public class solution27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sim2[] sims = new Sim2[4];
        for (int i = 0; i < sims.length; i++) {
            int a = Integer.parseInt(sc.nextLine());
            String b = sc.nextLine();
            int c = Integer.parseInt(sc.nextLine());
            double d = sc.nextDouble(); sc.nextLine();
            String e = sc.nextLine();
            sims[i] = new Sim2(a, b, c, d, e);
        }
        String search_circle = sc.nextLine();
        double search_rate = sc.nextDouble(); sc.nextLine();
        Sim2[] ans = matchAndSort(sims,search_circle,search_rate);
        if (ans!=null) {
            for (int i = 0; i < ans.length; i++) {
                System.out.println(ans[i].getId());
            }
        }
    }
    public static Sim2[] matchAndSort(Sim2[] sims, String c, double r){
        Sim2[] arr = new Sim2[0];
        for (int i = 0; i < sims.length; i++) {
            if (sims[i].getCircle().equalsIgnoreCase(c)&& r>sims[i].getRate()) {
                arr = Arrays.copyOf(arr, arr.length+1);
                arr[arr.length-1] = sims[i];
                Arrays.sort(arr, (a,b)->Integer.compare(b.getBalance(), a.getBalance()));
            }
        }
        if (arr.length>0) {
            return arr;
        }
        return null;
    }
}
class Sim2{
    private int id;
    private String company;
    private int balance;
    private double ratePerSecond;
    private String circle;
    public Sim2(int id, String company, int balance, double ratePerSecond, String circle){
        this.id = id;
        this.company = company;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getCompany(){
        return company;
    }
    public void setCompany(String company){
        this.company = company;
    }
    public int getBalance(){
        return balance;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }
    public double getRate(){
        return ratePerSecond;
    }
    public void setRate(double ratePerSecond){
        this.ratePerSecond = ratePerSecond;
    }
    public String getCircle(){
        return circle;
    }
    public void setCircle(String circle){
        this.circle = circle;
    }
}