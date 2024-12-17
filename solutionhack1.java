import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class solutionhack1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Student[] students = new Student[n];
        for (int i = 0; i < students.length; i++) {
            int a = Integer.parseInt(sc.nextLine());
            String b = sc.nextLine();
            int c = Integer.parseInt(sc.nextLine());
            students[i] = new Student(a, b, c);
        }
        String highesttotalstudent = findStudentwithhighesttotal(students);
        System.out.println(highesttotalstudent);
        List<Integer> studentsbypercentage = searchstudentsbypercentage(students);
        if(studentsbypercentage!=null){
            for(int id: studentsbypercentage){
                System.out.println(id);
            }
        }else System.out.println("No students found with mentioned attribute.");
    }
    public static String findStudentwithhighesttotal(Student[] students){
        Student highmarkobt = students[0];
        for(Student student: students){
            if (student.getMarksobt()>highmarkobt.getMarksobt()) {
                highmarkobt = student;
            }
        }
        return highmarkobt.getName().toUpperCase();
    }
    public static List<Integer> searchstudentsbypercentage(Student[] students){
        List<Integer> qs = new ArrayList<>();
        for(Student student: students){
            double per = (student.getMarksobt()/400.0)*100;
            if(per>=70.0){
                qs.add(student.getId());
            }
        }
        if (qs.isEmpty()) {
            return null;
        }
        Collections.sort(qs);
        return qs;
    }
}
class Student{
    private int id;
    private String name;
    private int totmarkobt;
    public Student(int id, String name, int totmarkobt){
        this.id = id;
        this.name = name;
        this.totmarkobt = totmarkobt;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getMarksobt(){
        return totmarkobt;
    }
    public void setMarksobt(int totmarkobt){
        this.totmarkobt = totmarkobt;
    }
}