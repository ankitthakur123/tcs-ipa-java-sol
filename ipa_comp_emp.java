import java.util.Scanner;
import java.util.Arrays;

public class ipa_comp_emp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter company name: ");
        String cn = sc.nextLine();
        System.out.print("Enter number of employees: ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.println("Enter employee details:");
        Employee[] emp = new Employee[num];
        for (int i = 0; i < emp.length; i++) {
            System.out.println("Employee "+(i+1)+":");
            System.out.print("Enter id: ");
            int a = Integer.parseInt(sc.nextLine());
            System.out.print("Enter name: ");
            String b = sc.nextLine();
            System.out.print("Enter designation: ");
            String c = sc.nextLine();
            System.out.print("Enter salary: ");
            double d = sc.nextDouble(); sc.nextLine();
            emp[i] = new Employee(a, b, c, d);
        }
        Company com = new Company(cn, emp, num);
        System.out.println("Average salary: "+com.getAverageSalary(emp));
        System.out.println("Max salary "+com.getMaxSalary(emp));
        System.out.print("Employees with designation: ");
        String des = sc.nextLine();
        Employee[] ans = com.getEmployeesByDesignation(emp, des);
        if(ans!=null){
            for (int i = 0; i < ans.length; i++) {
                System.out.println("id: "+ans[i].getId()+", "+"Name: "+ans[i].getName()+", "+"Designation: "+ans[i].getDes()+", "+"Salary: "+ans[i].getSalary());
            }
        }
    }
}
class Employee{
    private int id;
    private String name;
    private String designation;
    private double salary;
    public Employee(int id, String name, String designation, double salary){
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDes(){
        return designation;
    }
    public double getSalary(){
        return salary;
    }
}
class Company{
    private String companyName;
    private Employee[] employees;
    private int numEmployees;
    public Company(String companyName, Employee[] employees, int numEmployees){
        this.companyName = companyName;
        this.employees = employees;
        this.numEmployees = numEmployees;
    }
    public double getAverageSalary(Employee[] employees){
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum+=employees[i].getSalary();
        }
        if(sum>0){
            double avg = sum/employees.length;
            return avg;
        }
        return 0;
    }
    public double getMaxSalary(Employee[] employees){
        double maxsalary = employees[0].getSalary();
        for (int i = 1; i < employees.length; i++) {
            if(maxsalary<employees[i].getSalary()){
                maxsalary = employees[i].getSalary();
            }
        }
        return maxsalary;
    }
    public Employee[] getEmployeesByDesignation(Employee[] employees, String des){
        Employee[] arr = new Employee[0];
        for (int i = 1; i < employees.length; i++){
            if(employees[i].getDes().equalsIgnoreCase(des)){
                arr = Arrays.copyOf(arr, arr.length+1);
                arr[arr.length-1] = employees[i];
            }
        }
        if(arr.length>0){
            return arr;
        }
        return null;
    }
}