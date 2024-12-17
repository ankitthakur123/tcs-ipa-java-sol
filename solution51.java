import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class solution51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Beach[] beachs = new Beach[4];
        for (int i = 0; i < beachs.length; i++) {
            int a = Integer.parseInt(sc.nextLine());
            String b = sc.nextLine();
            int c = Integer.parseInt(sc.nextLine());
            int d = Integer.parseInt(sc.nextLine());
            beachs[i] = new Beach(a,b,c,d);
        }
        String e = sc.nextLine();
        int f = Integer.parseInt(sc.nextLine());
        int ans = findLeastRatingWithName(beachs,e,f);
        if (ans!=0) {
            System.out.println(ans);
        }else System.out.println("No data found");
    }

    public static int findLeastRatingWithName(Beach[] arr, String e, int f){
        ArrayList<Integer> rating = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getName().equalsIgnoreCase(e) && arr[i].getCost()>f){
                rating.add(arr[i].getRating());
                //Collections.sort(rating);
            }
        }
        if(rating.size()>0){
            Collections.sort(rating);
            return rating.get(0);
        }
        return 0;
    } 
}


class Beach {
    private int beachId;
    private String beachName;
    private int beachRating;
    private int beachCost;

    public Beach(int beachId, String beachName, int beachRating, int beachCost){
        this.beachId = beachId;
        this.beachName = beachName;
        this.beachRating = beachRating;
        this.beachCost = beachCost;
    }
    public int getId(){
        return beachId;
    }
    public void setId(int beachId){
        this.beachId = beachId;
    }
    public String getName(){
        return beachName;
    }
    public void setName(String beachName){
        this.beachName = beachName;
    }
    public int getRating(){
        return beachRating;
    }
    public void setRating(int beachRating){
        this.beachRating = beachRating;
    }
    public int getCost(){
        return beachCost;
    }
    public void setSalary(int beachCost){
        this.beachCost = beachCost;
    }
}