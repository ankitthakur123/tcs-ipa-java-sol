import java.util.*;
public class solution42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[2];
        Faculty[] faculties = new Faculty[2];
        for (int i = 0; i < students.length; i++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            char d = sc.nextLine().charAt(0);
            String e = sc.nextLine();
            String f = sc.nextLine();
            int g = Integer.parseInt(sc.nextLine());
            double h = sc.nextDouble(); sc.nextLine();
            students[i] = new Student(a, b, c, d, e, f, g, h);
        }
        for (int i = 0; i < faculties.length; i++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            char d = sc.nextLine().charAt(0);
            String e = sc.nextLine();
            String f = sc.nextLine();
            String g = sc.nextLine();
            double h = sc.nextDouble(); sc.nextLine();
            faculties[i] = new Faculty(a, b, c, d, e, f, g, h);
        }
        Student ans = findHighestGPAStudent(students);
        Faculty ans1 = findHighestPaidFaculty(faculties);
        if (ans!=null) {
            System.out.println(ans.getrollNo());
            System.out.println(ans.getCourse());
            System.out.println(ans.getGpa());
        }else System.out.println("Sorry - No student is available");
        if (ans1!=null) {
            System.out.println(ans1.getId());
            System.out.println(ans1.getDepartment());
            System.out.println(ans1.getSalary());
        }else System.out.println("Sorry - No faculty is available");
    }
    public static Student findHighestGPAStudent(Student[] students){
        for (int i = 0; i < students.length; i++) {
            Arrays.sort(students,(a,b)->Double.compare(a.getGpa(), b.getGpa()));
        }
        if (students.length>0) {
            return students[students.length-1];
        }
        return null;
    }
    public static Faculty findHighestPaidFaculty(Faculty[] faculties){
        for (int i = 0; i < faculties.length; i++) {
            Arrays.sort(faculties,(a,b)->Double.compare(a.getSalary(), b.getSalary()));
        }
        if (faculties.length>0) {
            return faculties[faculties.length-1];
        }
        return null;
    }
    
}

class Person {
     String firstName;
     String lastName;
     int age;
     char gender;
    public Person(String firstName, String lastName, int age, char gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }
    public String getFirsttName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public char getGender(){
        return gender;
    }
    public void setGender(char gender){
        this.gender = gender;
    }
}
class Student extends Person {
     String rollNo;
     String course;
     int semester;
     double GPA;
    public Student(String firstName, String lastName, int age, char gender, String rollNo, String course, int semester, double GPA){
        super(firstName, lastName, age, gender);
        this.rollNo = rollNo;
        this.course = course;
        this.semester = semester;
        this.GPA = GPA;
    }
    public String getrollNo(){
        return rollNo;
    }
    public void setrollNo(String rollNo){
        this.rollNo = rollNo;
    }
    public String getCourse(){
        return course;
    }
    public void setCourse(String course){
        this.course = course;
    }
    public int getSemester(){
        return semester;
    }
    public void setSemester(int semester){
        this.semester = semester;
    }
    public double getGpa(){
        return GPA;
    }
    public void setGpa(double GPA){
        this.GPA = GPA;
    }
}

class Faculty extends Person {
    String employeeId;
    String department;
    String designation;
    double salary;
    public Faculty(String firstName, String lastName, int age, char gender, String employeeId, String department, String designation, double salary){
        super(firstName, lastName, age, gender);
        this.employeeId = employeeId;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }
    public String getId(){
        return employeeId;
    }
    public void setId(String employeeId){
        this.employeeId = employeeId;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public String getDesignation(){
        return designation;
    }
    public void setDesignation(String designation){
        this.designation = designation;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
}