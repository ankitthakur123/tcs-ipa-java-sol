import java.util.Scanner;

public class solution53 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Course [] courses = new Course[4];
        for (int i = 0; i < courses.length; i++) {
            String a = sc.nextLine();
            int b = Integer.parseInt(sc.nextLine());
            String c = sc.nextLine();
            boolean d = sc.nextBoolean(); sc.nextLine();
            courses[i]  = new Course(a, b, c, d);
        }
        String e = sc.nextLine();
        int ans = findCourseStatus(courses,e);
        if (ans==1) {
            System.out.println("High");
        }else if(ans==2) System.out.println("Medium");
        else System.out.println("Low");
        if (ans==3) {
            System.out.println("No courses found");
        }
    }

    public static int findCourseStatus(Course[] courses, String e){
        for (int i = 0; i < courses.length; i++){
           if(courses[i].getName().equalsIgnoreCase(e)){
            if (courses[i].getNumber()>=1000) {
                return 1;
            }else if (courses[i].getNumber()>=500&&courses[i].getNumber()<1000) {
                return 2;
            }else return 0;
        }
        }
       return 3; 
    }
}

class Course {
    private String CourseName;
    private int CourseNumber;
    private String Mode;
    private boolean Sharedata;
    
    public Course(String CourseName, int CourseNumber, String Mode, boolean Sharedata){
        this.CourseName = CourseName;
        this.CourseNumber = CourseNumber;
        this.Mode = Mode;
        this.Sharedata = Sharedata;
    }
    public String getName(){
        return CourseName;
    }
    public void setName(String CourseName){
        this.CourseName = CourseName;
    }
    public int getNumber(){
        return CourseNumber;
    }
    public void setNumber(int CourseNumber){
        this.CourseNumber = CourseNumber;
    }
    public String getMode(){
        return Mode;
    }
    public void setMode(String Mode){
        this.Mode = Mode;
    }
    public boolean isSharedata(){
        return Sharedata;
    }
    public void setSharedata(boolean Sharedata){
        this.Sharedata = Sharedata;
    }
}

