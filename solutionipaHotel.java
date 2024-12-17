import java.util.Arrays;
import java.util.Scanner;

public class solutionipaHotel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel[] hotels = new Hotel[4];
        for (int i = 0; i < hotels.length; i++) {
            int a = Integer.parseInt(sc.nextLine());
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = Integer.parseInt(sc.nextLine());
            String e = sc.nextLine();
            double f = sc.nextDouble(); sc.nextLine();
            hotels[i] = new Hotel(a, b, c, d, e, f);
        }
        String g = sc.nextLine();
        String h = sc.nextLine();
        int ans1 = noOfRoomsBookedInGivenMonth(hotels, g);
        if(ans1>0) System.out.println(ans1);
        else System.out.println("No rooms booked in the given month");
        Hotel ans2 = searchHotelByWifiOption(hotels,h);
        if(ans2!=null) System.out.println(ans2.getId());
        else System.out.println("No such option available");
    }
    public static int noOfRoomsBookedInGivenMonth(Hotel[] hotels, String g){
        int sum = 0;
        for (int i = 0; i < hotels.length; i++){
            String month = hotels[i].getDate().substring(3, 6);
            if(month.equalsIgnoreCase(g)){
                sum+=hotels[i].getBooked();
            }
        }
        if(sum>0) return sum;
        return 0;
    }
    public static Hotel searchHotelByWifiOption(Hotel[] hotels, String h){
        Hotel[] arr = new Hotel[0];
        for (int i = 0; i < hotels.length; i++){
            if(hotels[i].getFacility().equalsIgnoreCase(h)){
                arr = Arrays.copyOf(arr, arr.length+1);
                arr[arr.length-1] = hotels[i];
            }
        }
        if(arr.length>0){
            Arrays.sort(hotels, (a, b) -> Double.compare(a.getBill(), b.getBill()));
            return arr[arr.length-2];
        }
        return null;
    }
}
class Hotel{
    int hotelId;
    String hotelName;
    String dateOfBooking;
    int noOfRoomsBooked;
    String wifiFacility;
    double totalBill;
    public Hotel(int hotelId, String hotelName, String dateOfBooking, int noOfRoomsBooked,  String wifiFacility, double totalBill){
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.dateOfBooking = dateOfBooking;
        this.noOfRoomsBooked = noOfRoomsBooked;
        this.wifiFacility = wifiFacility;
        this.totalBill = totalBill;
    }
    public int getId(){
        return hotelId;
    }
    public String getName(){
        return hotelName;
    }
    public String getDate(){
        return dateOfBooking;
    }
    public int getBooked(){
        return noOfRoomsBooked;
    }
    public String getFacility(){
        return wifiFacility;
    }
    public double getBill(){
        return totalBill;
    }
}