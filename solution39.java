import java.util.Arrays;
import java.util.Scanner;

public class solution39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vegetable[] vegs = new Vegetable[4];
        for (int i = 0; i < vegs.length; i++) {
            int a = Integer.parseInt(sc.nextLine());
            String b = sc.nextLine();
            int c = Integer.parseInt(sc.nextLine());
            int d = Integer.parseInt(sc.nextLine());
            vegs[i] = new Vegetable(a, b, c, d);
        }
        int r = Integer.parseInt(sc.nextLine());
        Vegetable ans = findMinimumPriceByRating(vegs, r);
        if (ans!=null) {
            System.out.println(ans.getID());
        }else System.out.println("No such Vegetables");
    }
    public static Vegetable findMinimumPriceByRating(Vegetable[] vegs, int r){
        for (int i = 0; i < vegs.length; i++) {
            if (vegs[i].getRating()>r) {
                Arrays.sort(vegs,(a,b)->Integer.compare(a.getPrice(), b.getPrice()));
                return vegs[0];
            }
        }
        return null;
    }
}

class Vegetable {
    private int VegetableId;
    private String VegetableName;
    private int Price;
    private int Rating;

    public Vegetable(int VegetableId, String VegetableName, int Price, int Rating){
        this.VegetableId = VegetableId;
        this.VegetableName = VegetableName;
        this.Price = Price;
        this.Rating = Rating;
    }
    public int getID(){
        return VegetableId;
    }
    public void setId(int VegetableId){
        this.VegetableId = VegetableId;
    }
    public String getName(){
        return VegetableName;
    }
    public void setName(String VegetableName){
        this.VegetableName = VegetableName;
    }
    public int getPrice(){
        return Price;
    }
    public void setPrice(int Price){
        this.Price = Price;
    }
    public int getRating(){
        return Rating;
    }
    public void setRating(int Rating){
        this.Rating = Rating;
    }
}