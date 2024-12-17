import java.util.Scanner;

public class solutionipa_mock {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        Course[] courses = new Course[4];
        for(int i=0; i<courses.length; i++){
            int a = Integer.parseInt(sc.nextLine());
            String b = sc.nextLine();
            double c = sc.nextDouble(); sc.nextLine();
            String d = sc.nextLine();
            boolean e = sc.nextBoolean(); sc.nextLine();
            courses[i] = new Course(a,b,c,d,e);
        }
        double d = sc.nextDouble(); sc.nextLine();
        String s = sc.nextLine();
        int ans = CountCourse(courses, s, d);
        if(ans>0){
            System.out.println(ans);
        }else System.out.println("No course found");
    }
    public static int CountCourse(Course[] c, String s, double d){
        int count = 0;
        for(int i=0; i<c.length; i++){
            if(c[i].getRating()>=d&&c[i].getMode().equalsIgnoreCase(s)&&c[i].havecerti()){
                count++;
            }
        }
        if(count>0) return count;
        return 0;
    }
}
class Course{
     int CourseId;
     String CourseName;
     double CourseRating;  
     String Mode;
     boolean HaveCertificate;
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
    public String getName(){
        return CourseName;
}
    public double getRating(){
        return CourseRating;
}
    public String getMode(){
        return Mode;
}
    public boolean havecerti(){
        return HaveCertificate;
}
}

