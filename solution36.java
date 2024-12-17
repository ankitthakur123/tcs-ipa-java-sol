import java.util.Arrays;
import java.util.Scanner;

public class solution36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MobileDetails[] mob = new MobileDetails[5];
        for (int i = 0; i < mob.length; i++) {
            int a = Integer.parseInt(sc.nextLine());
            int b = Integer.parseInt(sc.nextLine());
            String c = sc.nextLine();
            boolean d = sc.nextBoolean(); sc.nextLine();
            mob[i] = new MobileDetails(a, b, c, d);
        }
        String s = sc.nextLine();
        int ans = getTotalPrice(mob, s);
        if (ans!=0) {
            System.out.println(ans);
        }else System.out.println("There are no mobile with given brand");
        MobileDetails[] ans2 = getSecondMin(mob);
        for (int i = 0; i < ans2.length; i++) {
            System.out.println(ans2[i].getBrand()+" : "+ ans2[i].getPrice());
        }
    }
    public static int getTotalPrice(MobileDetails[] mob, String s){
        int sum = 0;
        for (int i = 0; i < mob.length; i++) {
            if (mob[i].getBrand().equalsIgnoreCase(s)) {
                sum = sum + mob[i].getPrice();
            }
        }
        if(sum>0) return sum;
        return 0;
    }
    public static MobileDetails[] getSecondMin(MobileDetails[] mob){
        MobileDetails[] arr = new MobileDetails[0];
        Arrays.sort(mob, (a,b)->Integer.compare(a.getPrice(), b.getPrice()));
        for(MobileDetails ob : mob){
            if(ob.getPrice()==mob[1].getPrice()){
                arr = Arrays.copyOf(arr,arr.length+1);
                arr[arr.length-1] = ob;
            }
        }
        return arr;
    }
}

class MobileDetails {
    private int MobileId;
    private int Price;
    private String Brand;
    private boolean isFlagShip;

    public MobileDetails(int MobileId, int Price, String Brand, boolean isFlagShip){
        this.MobileId = MobileId;
        this.Price = Price;
        this.Brand = Brand;
        this.isFlagShip = isFlagShip;
    }
    public int getId(){
        return MobileId;
    }
    public void setId(int MobileId){
        this.MobileId = MobileId;
    }
    public int getPrice(){
        return Price;
    }
    public void setPrice(int Price){
        this.Price = Price;
    }
    public String getBrand(){
        return Brand;
    }
    public void setBrand(String Brand){
        this.Brand = Brand;
    }
    public boolean getisflagship(){
        return isFlagShip;
    }
    public void setisflagship(boolean isFlagShip){
        this.isFlagShip = isFlagShip;
    }
}