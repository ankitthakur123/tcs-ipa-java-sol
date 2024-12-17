import java.util.Scanner;
import java.util.Arrays;
public class solution17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[4];
        for (int i = 0; i < students.length; i++) {
            int a = Integer.parseInt(sc.nextLine());
            String b = sc.nextLine();
            String c = sc.nextLine();
            char d = sc.nextLine().charAt(0);
            String e = sc.nextLine();
            students[i] = new Student(a, b, c, d, e);
        }
        char f = sc.nextLine().charAt(0);
        int g = Integer.parseInt(sc.nextLine());
        Student[] ans = findStudentByGradeAndMonth(students,f,g);
        if(ans!=null){
            for (int i = 0; i < ans.length; i++) {
                System.out.println(ans[i].getName());
                System.out.println(ans[i].getSubject());
            }
            System.out.println(ans.length);
        }else System.out.println( "No student found");
    }
    public static Student[] findStudentByGradeAndMonth(Student[] students, char f, int g){
        Student[] arr = new Student[0];
        for (int i = 0; i < students.length; i++) {
            int month = Integer.parseInt(students[i].getDate().substring(3,5));
            if(students[i].getGrade()==f && month==g){
                arr = Arrays.copyOf(arr, arr.length+1);
                arr[arr.length-1] = students[i];
            }
        }
        if(arr.length>0){
            Arrays.sort(arr, (a,b)->Integer.compare(a.getRollNo(), b.getRollNo()));
            return arr;
        }
        return null;
    }
}
class Student{
    int rollNo;
    String name;
    String subject;
    char grade;
    String date;
    public Student(int rollNo, String name, String subject, char grade, String date){
        this.rollNo = rollNo;
        this.name = name;
        this.subject = subject;
        this.grade = grade;
        this.date = date;
    }
    public int getRollNo(){
        return rollNo;
    }
    public String getName(){
        return name;
    }
    public String getSubject(){
        return subject;
    }
    public char getGrade(){
        return grade;
    }
    public String getDate(){
        return date;
    }
}