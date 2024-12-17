import java.util.Arrays;
import java.util.Scanner;

public class solution31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Music[] musics = new Music[4];
        for (int i = 0; i < musics.length; i++) {
            int a = Integer.parseInt(sc.nextLine());
            String b = sc.nextLine();
            int c = Integer.parseInt(sc.nextLine());
            double d = sc.nextDouble(); sc.nextLine();
            musics[i] = new Music(a, b, c, d);
        }
        int val = Integer.parseInt(sc.nextLine());
        double dur = sc.nextDouble(); sc.nextLine();
        int ans1 = findAvgOfCount(musics, val);
        if(ans1!=0){
            System.out.println(ans1);
        }else System.out.println("No playlist found");
        Music[] ans2 = sortTypeByDuration(musics, dur);
        if (ans2!=null) {
            for (int i = 0; i < ans2.length; i++) {
                System.out.println(ans2[i].getType());
            }
        }else System.out.println("No playlist found with mentioned attribute");
    }
    public static int findAvgOfCount(Music[] musics, int val){
        int cnt = 0, sum = 0;
        for (int i = 0; i < musics.length; i++) {
            if(musics[i].getCount()>val){
                sum+=musics[i].getCount();
                cnt++;
            }
        }
        if(cnt>0) return sum/cnt;
        return 0;
    }
    public static Music[] sortTypeByDuration(Music[] musics, double dur){
        Music[] arr = new Music[0];
        for (int i = 0; i < musics.length; i++) {
            if(musics[i].getDuration()>dur){
                arr = Arrays.copyOf(arr, arr.length+1);
                arr[arr.length-1] = musics[i];
            }
        }
        if(arr.length>0){
            Arrays.sort(arr, (a,b)->Double.compare(a.getDuration(), b.getDuration()));
            return arr;
        }
        return null;
    }
}
class Music{
    private int playListNo;
    private String type;
    private int count;
    private double duration;

    public Music(int playListNo, String type, int count, double duration){
        this.playListNo = playListNo;
        this.type = type;
        this.count = count;
        this.duration = duration;
    }
    public int getNo(){
        return playListNo;
    }
    public void setNo(int playListNo){
        this.playListNo = playListNo;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    public int getCount(){
        return count;
    }
    public void setCount(int count){
        this.count = count;
    }
    public double getDuration(){
        return duration;
    }
    public void setDuration(double duration){
        this.duration = duration;
    }
}