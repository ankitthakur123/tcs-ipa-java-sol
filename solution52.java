import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
public class solution52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee [] employees = new Employee[5];
        for (int i = 0; i < employees.length; i++) {
            int a = Integer.parseInt(sc.nextLine());
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = Integer.parseInt(sc.nextLine());
            int e = Integer.parseInt(sc.nextLine());
            employees[i]  = new Employee(a, b, c, d, e);
        }
        int f = Integer.parseInt(sc.nextLine());
        String g = sc.nextLine();
        String[] ans1 = findDept(employees, f);
        if (ans1!=null) {
            String dep = Arrays.toString(ans1);
            String de = dep.substring(1, dep.length()-1);
            System.out.println(de);
        }else System.out.println("No Department found");
        int ans2 = findSecondHighestSalary(employees, g);
        if (ans2!=0) {
            System.out.println(ans2);
        }else System.out.println("No Data found");
    }
    
    public static String[] findDept(Employee[] employees, int f){
        ArrayList<String> departments = new ArrayList<>();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary()==f && employees[i].getRating()>=3) {
                departments.add(employees[i].getDept());
            }
        }
        if (!departments.isEmpty()) {
            return departments.toArray(new String[0]);
        }
        return null;
    }
    
    public static int findSecondHighestSalary(Employee[] emp, String g){
        ArrayList<Integer> sal = new ArrayList<>();
        for (int i = 0; i < emp.length; i++) {
            if (emp[i].getDept().equalsIgnoreCase(g)) {
                sal.add(emp[i].getSalary());
                Collections.sort(sal);
            }
        }
        if (sal.size()>0) {
            for (int i = 0; i < sal.size(); i++) {
                if (sal.get(i)<sal.get(i+1)) {
                    return sal.get(i);
                }
            }
        }
        return 0;
    }
}

class Employee {
    private int EmpId;
    private String EmpName;
    private String Dept;
    private int Rating;
    private int Salary;
    
    public Employee(int EmpId, String EmpName, String Dept, int Rating, int Salary){
        this.EmpId = EmpId;
        this.EmpName = EmpName;
        this.Dept = Dept;
        this.Rating = Rating;
        this.Salary = Salary;
    }
    public int getId(){
        return EmpId;
    }
    public void setId(int EmpId){
        this.EmpId = EmpId;
    }
    public String getName(){
        return EmpName;
    }
    public void setName(String EmpName){
        this.EmpName = EmpName;
    }
    public String getDept(){
        return Dept;
    }
    public void setDept(String Dept){
        this.Dept = Dept;
    }
    public int getRating(){
        return Rating;
    }
    public void setRating(int Rating){
        this.Rating = Rating;
    }
    public int getSalary(){
        return Salary;
    }
    public void setSalary(int Salary){
        this.Salary = Salary;
    }
}

