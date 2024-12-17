import java.util.Scanner;

public class solutionipa23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Institution[] institutes = new Institution[4];
        for (int i = 0; i < institutes.length; i++) {
            int a = Integer.parseInt(sc.nextLine());
            String b = sc.nextLine();
            int c = Integer.parseInt(sc.nextLine());
            int d = Integer.parseInt(sc.nextLine());
            String e = sc.nextLine();
            institutes[i] = new Institution(a, b, c, d, e);
        }
        String g = sc.nextLine();
        String h = sc.nextLine();
        int ans = FindNumClearancedByLoc(institutes, g);
        if(ans>0) System.out.println(ans);
        else System.out.println("There are no cleared students in this particular location");
        Institution ans1 = UpdateInstitutionGrade(institutes, h);
        if(ans1!=null){
            System.out.println(ans1.getName()+"::"+ans1.getGrade());
        }else System.out.println("No Institute is available with the specified name");
    }
    public static int FindNumClearancedByLoc(Institution[] institutes, String loc){
        int sum = 0;
        for (int i = 0; i< institutes.length; i++) {
            if(institutes[i].getLocation().equalsIgnoreCase(loc)){
                sum+=institutes[i].getCleared();
            }
        }
        if(sum>0){
            return sum;
        }
        return 0;
    }
    public static Institution UpdateInstitutionGrade(Institution[] institutes, String Name){
        for (int i = 0; i < institutes.length; i++) {
            if(institutes[i].getName().equalsIgnoreCase(Name)){
                int Rating=(institutes[i].getPlaced() * 100)/institutes[i].getCleared();
                if(Rating>=80){
                    institutes[i].setGrade("A");
                    return institutes[i];
                }else{
                    institutes[i].setGrade("A");
                    return institutes[i];
                }
            }
        }
        return null;
    }
}
class Institution{
    private int institutionId;
    private String institutionName;
    private int noOfStudentsPlaced;
    private int noOfStudentsCleared;
    private String location;
    private String grade;
    public Institution(int institutionId, String institutionName, int noOfStudentsPlaced, int noOfStudentsCleared, String location){
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.noOfStudentsPlaced = noOfStudentsPlaced;
        this.noOfStudentsCleared = noOfStudentsCleared;
        this.location = location;
    }
    public String getName(){
        return institutionName;
    }
    public int getPlaced(){
        return noOfStudentsPlaced;
    }
    public int getCleared(){
        return noOfStudentsCleared;
    }
    public String getLocation(){
        return location;
    }
    public String getGrade(){
        return grade;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }
}