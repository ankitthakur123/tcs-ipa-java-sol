import java.util.Scanner;

public class solution16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NavalVessel[] NV = new NavalVessel[4];
        for (int i = 0; i < NV.length; i++) {
            int a = Integer.parseInt(sc.nextLine());
            String b = sc.nextLine();
            int c = Integer.parseInt(sc.nextLine());
            int d = Integer.parseInt(sc.nextLine());
            String e = sc.nextLine();
            NV[i] = new NavalVessel(a, b, c, d, e);
        }
        int per = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        int ans1 = findAvgVoyagesByPct(NV, per);
        if(ans1>0){
            System.out.println(ans1);
        }else System.out.println("no objects with given criteria");
        NavalVessel ans2 = findVesselByGrade(NV, s);
        if(ans2!=null){
            System.out.println(ans2.getName()+"%"+ans2.getClas());
        }else System.out.println("No Naval Vessel is available with the specified purpose");
    } 
    public static int findAvgVoyagesByPct(NavalVessel[] n, int p){
        int count = 0;
        int sum = 0;
        for (int i = 0; i < n.length; i++){
            int per = (n[i].getComp()*100)/n[i].getPlanned();
            if(per>=p){
                sum+=n[i].getComp();
                count++;
            }
        }
        int avg = sum/count;
        if(sum>0){
            return avg;
        }
        return 0;
    }
    public static NavalVessel findVesselByGrade(NavalVessel[] n, String s){
        for (int i = 0; i < n.length; i++){
            if(n[i].getPurpose().equalsIgnoreCase(s)){
               int per = (n[i].getComp()*100)/n[i].getPlanned();
               if(per==100) {
                n[i].setClas("Star");
                return n[i];
            }
               else if(per<99&&per>80) {
                n[i].setClas("Leader");
                return n[i];
            }
               else if(per<79&&per>55) {
                n[i].setClas("Inspirer");
                return n[i];
            }
               else {
                n[i].setClas("Striver");
                return n[i];
            }
        }
       }
       return null;
    }
}
class NavalVessel{
    int vesselld;
    String vesselName;
    int noOfVoyagesPlanned;
    int noOfVoyagesCompleted;
    String purpose;
    String clas;
    public NavalVessel(int vesselld, String vesselName, int noOfVoyagesPlanned, int noOfVoyagesCompleted, String purpose){
        this.vesselld = vesselld;
        this.vesselName = vesselName;
        this.noOfVoyagesPlanned = noOfVoyagesPlanned;
        this.noOfVoyagesCompleted = noOfVoyagesCompleted;
        this.purpose = purpose;
    }
    public int getId(){
        return vesselld;
    }
    public String getName(){
        return vesselName;
    }
    public int getPlanned(){
        return noOfVoyagesPlanned;
    }
    public int getComp(){
        return noOfVoyagesCompleted;
    }
    public String getPurpose(){
        return purpose;
    }
    public void setClas(String clas){
        this.clas = clas;
    }
    public String getClas(){
        return clas;
    }
}