import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
public class solution46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player[] players = new Player[4];
        for (int i = 0; i < players.length; i++) {
            int a = Integer.parseInt(sc.nextLine());
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble(); sc.nextLine();
            players[i] = new Player(a, b, c, d);
        }
        String s = sc.nextLine();
        Player[] ans = searchPlayerForMatch(players, s);
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < ans.length; i++) {
            arr.add(ans[i].getId());
            Collections.sort(arr);
        }
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    public static Player[] searchPlayerForMatch(Player[] players, String s){
        ArrayList<Player> matchingPlayers = new ArrayList<>();
    
    for (Player player : players) {
        if (player.getSide().equalsIgnoreCase(s)) {
            matchingPlayers.add(player);  // Add matching player to the list
        }
    }
    
    return matchingPlayers.toArray(new Player[0]);
    }
}

class  Player{
    private int id;
    private String country;
    private String side;
    private double price;
    
    public Player(int id, String country, String side, double price){
        this.id = id;
        this.country = country;
        this.side = side;
        this.price = price;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getCountry(){
        return country;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getSide(){
        return side;
    }
    public void setSide(String side){
        this.side = side;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
}