import java.util.Scanner;

public class solution54 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Course[] course = new Course[4];
        for (int i = 0; i<course.length; i++) {
            int a = Integer.parseInt(sc.nextLine());
            String b = sc.nextLine();
            double c = sc.nextDouble(); sc.nextLine();
            String d = sc.nextLine();
            boolean e = sc.nextBoolean(); sc.nextLine();
            course[i] = new Course(a, b, c, d, e);
        }
        double g = sc.nextDouble(); sc.nextLine();
        String f = sc.nextLine();
        int ans = CountCourse(course,f,g);
        if (ans>0) {
            System.out.println(ans);
        }else{
            System.out.println("No course found");
        }
    }
    public static int CountCourse(Course[] c, String f, double g){
        int count = 0;
        for (int i = 0; i<c.length; i++){
            if (c[i].isCertificate()==true&&c[i].getRating()>=g&&c[i].getMode().equalsIgnoreCase(f)) {
                count++;    
            }
        }
        return count;

    }
}
/**
 * course
 */
class Course {
    private int CourseId;
    private String CourseName;
    private double CourseRating;
    private String Mode;
    private boolean HaveCertificate;
    
    public Course(int CourseId, String CourseName, double CourseRating, String Mode, boolean HaveCertificate){
        this.CourseId = CourseId;
        this.CourseName = CourseName;
        this.CourseRating = CourseRating;
        this.Mode = Mode;
        this.HaveCertificate = HaveCertificate;
    }
    public int getId(){
        return CourseId;
    }
    public void setId(int CourseId){
        this.CourseId = CourseId;
    }
    public String getName(){
        return CourseName;
    }
    public void setName(String CourseName){
        this.CourseName = CourseName;
    }
    public double getRating(){
        return CourseRating;
    }
    public void setRating(double CourseRating){
        this.CourseRating = CourseRating;
    }
    public String getMode(){
        return Mode;
    }
    public void setMode(String Mode){
        this.Mode = Mode;
    }
    public boolean isCertificate(){
        return HaveCertificate;
    }
    public void setCertificate(boolean HaveCertificate){
        this.HaveCertificate = HaveCertificate;
    }


}
