import java.util.Arrays;
import java.util.Scanner;

public class solution43 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[4];
        for (int i = 0; i < students.length; i++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = Integer.parseInt(sc.nextLine());
            char d = sc.nextLine().charAt(0);
            String e = sc.nextLine();
            int f = Integer.parseInt(sc.nextLine());
            double g = sc.nextDouble(); sc.nextLine();
            students[i] = new Student(a, b, c, d, e, f, g);
        }
        String crs = sc.nextLine();
        double ans1 = calculateAverageGPA(students);
        Student[] ans2 = getStudentsByCourse(students, crs);
        if (ans1!=0) {
            System.out.println(ans1);
            System.out.println();
        }else System.out.println("Sorry - No students are available");
        if(ans2 != null)
        {
            for (int i = 0; i < ans2.length; i++) {
                System.out.println(ans2[i].getName());
                System.out.println(ans2[i].getRoll());
                System.out.println(ans2[i].getGpa());
            }
        }
        else
        {
            System.out.println("Sorry - No students are available for the given course");
        }
    }
    public static double calculateAverageGPA(Student[] students){
        double sum = 0;
        int cnt = 0;
        for(int i=0; i<students.length; i++){
            sum = students[i].getGpa() + sum;
            cnt++;
        }
        double avg = sum/(double)cnt;
        if (students.length>0) {
            return avg;
        }
        return 0;
    }
    public static Student[] getStudentsByCourse(Student[] students, String s){
        Student[] arr = new Student[0];
        for (int i = 0; i < students.length; i++) {
            if(students[i].getCourse().equalsIgnoreCase(s)){
                arr = Arrays.copyOf(arr, arr.length+1);
                arr[arr.length-1] = students[i];
            }
        }
        if (arr.length>0) {
            return arr;
        }
        return null;
    }
}
class Student{
    private String name;
    private String rollNo;
    private int age;
    private char gender;
    private String course;
    private int semester;
    private double GPA;

    public Student(String name,String rollNo,int age,char gender,String course,int semester,double GPA){
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
        this.gender = gender;
        this.course = course;
        this.semester = semester;
        this.GPA = GPA;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getRoll(){
        return rollNo;
    }
    public void setRoll(String rollNo){
        this.rollNo = rollNo;
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