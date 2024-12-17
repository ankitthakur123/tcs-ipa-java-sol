import java.util.Arrays;
import java.util.Scanner;

public class solution10 {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       Employee[] emp = new Employee[4];
       for(int i=0; i<emp.length; i++){
            int a = Integer.parseInt(sc.nextLine());
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble(); sc.nextLine();
            boolean e = sc.nextBoolean(); sc.nextLine();
            emp[i] = new Employee(a,b,c,d,e);
       }
       String s = sc.nextLine();
       int ans1 = findCountOfEmployeesUsingCompTransport(emp, s);
       if(ans1>0) System.out.println(ans1);
       else System.out.println("No such Employee");
       Employee ans2 = findEmployeeWithSecondHighestRating(emp);
       if(ans2!=null){
          System.out.println(ans2.getId());
          System.out.println(ans2.getName());
       }else System.out.print("All Employees using company transport");
   }
   public static int findCountOfEmployeesUsingCompTransport(Employee[] emp, String s){
        int count = 0;
        for(int i=0; i<emp.length; i++){
            if(emp[i].getBranch().equalsIgnoreCase(s)){
                 count++;
             }
        }
        if(count>0) return count;
        return 0;
   }
   public static Employee findEmployeeWithSecondHighestRating(Employee[] emp){
       Employee[] arr = new Employee[0];
       for(int i=0; i<emp.length; i++){
            if(!emp[i].isTransport()){
                arr = Arrays.copyOf(arr, arr.length+1);
                arr[arr.length-1] = emp[i];
             }
        }
       if(arr.length>0){
            //Arrays.sort(arr, (a,b)-> Double.compare(a.getRating(), b.getRating()));
            Employee k = null;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i+1; j < arr.length; j++) {
                    if(arr[i].getRating()>arr[j].getRating()){
                        k = arr[i];
                        arr[i] = arr[j];
                        arr[j] = k;
                    }
                }
            }
            return arr[arr.length-2];
        }
       return null;
   }
}
class Employee{
   int id;
   String name;
   String branch;
   double rating;
   boolean transport;
  public Employee(int id, String name, String branch, double rating, boolean transport){
   this.id = id;
   this.name = name;
   this.branch = branch;
   this.rating = rating;
   this.transport = transport;
}
  public int getId(){
      return id;
  }
  public String getName(){
      return name;
  }
  public String getBranch(){
     return branch;
  }
  public double getRating(){
     return rating;
  }
  public boolean isTransport(){
     return transport;
  }
}


