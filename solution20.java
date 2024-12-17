import java.util.Scanner;
import java.util.Arrays;
public class solution20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Engine[] eng = new Engine[4];
        for (int i = 0; i < eng.length; i++) {
            int a = Integer.parseInt(sc.nextLine());
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble(); sc.nextLine();
            eng[i] = new Engine(a, b, c, d);
        }
        String e = sc.nextLine();
        String f = sc.nextLine();
        int ans = findAvgEnginePriceByType(eng, e);
        if(ans>0){
            System.out.println(ans);
        }else System.out.println("There are no engine with given type");
        Engine[] arr = searchEngineByName(eng, f);
        if(arr!=null){
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i].getId());
            }
        }else System.out.println("There are no engine with the given name");
    }
    public static int findAvgEnginePriceByType(Engine[] eng, String e){
        int sum = 0, cnt = 0;
        for (int i = 0; i < eng.length; i++) {
            if(eng[i].getType().equalsIgnoreCase(e)){
                sum+=eng[i].getPrice();
                cnt++;
            }
        }
        if(cnt>0){
            return sum/cnt;
        }
        return 0;
    }
    public static Engine[] searchEngineByName(Engine[] eng, String f){
        Engine[] arr = new Engine[0];
        for (int i = 0; i < eng.length; i++) {
            if(eng[i].getName().equalsIgnoreCase(f)){
                arr = Arrays.copyOf(arr, arr.length+1);
                arr[arr.length-1] = eng[i];
            }
        }
        if(arr.length>0){
            Arrays.sort(arr,(a,b)->Integer.compare(a.getId(), b.getId()));
            return arr;
        }
        return null;
    }
}
class Engine{
    int engineld;
    String engineName;
    String engineType;
    double enginePrice;
    public Engine(int engineld, String engineName, String engineType, double enginePrice){
        this.engineld = engineld;
        this.engineName = engineName;
        this.engineType = engineType;
        this.enginePrice = enginePrice;
    }
    public int getId(){
        return engineld;
    }
    public String getName(){
        return engineName;
    }
    public String getType(){
        return engineType;
    }
    public double getPrice(){
        return enginePrice;
    }
}