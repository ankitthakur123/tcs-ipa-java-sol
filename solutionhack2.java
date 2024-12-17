import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class solutionhack2 {
    public void getBooksBelongingToAGenre(List<Book> books, String genre){
        boolean found = false;
        genre = genre.toLowerCase();
        for(Book book: books){
            if(book.getGenre().toLowerCase().equals(genre)){
                found = true;
                System.out.println("AuthorName: "+ book.getAuthor().getauthorName()+ ", Title: "+ book.getTitle());
            }
        }
        if (!found) {
            System.out.println("Genre is not available in the list");
        }
    }
    public void calculateDiscountedPrice(List<Book> books, String genre, double discount){
        boolean found = false;
        genre = genre.toLowerCase();
        List<Book> discountedBooks = new ArrayList<>();
        for(Book book: books){
            if(book.getGenre().toLowerCase().equals(genre)){
                found =  true;
                double discountedprice = book.getPrice()*(1-discount/100);
                book.setPrice(discountedprice);
                discountedBooks.add(book);
            }
        }
        if (found) {
            System.out.println("\nDiscounted "+ genre + " Books:");
            for(Book book: discountedBooks){
                System.out.println("AuthorName: "+ book.getAuthor().getauthorName()+ ", Title: "+ book.getTitle()+ ", Updated Price: "+ book.getPrice());
            } 
        }else System.out.println("Discounted books are unavailable in the given genre");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(sc.nextLine());
            String b = sc.nextLine();
            Author author = new Author(a, b);
            int c = Integer.parseInt(sc.nextLine());
            String d = sc.nextLine();
            String e = sc.nextLine();
            double f = sc.nextDouble(); sc.nextLine();
            books.add(new Book(c, d, e, f, author));
        }
        String sg = sc.nextLine();
        String dg = sc.nextLine();
        double dp = sc.nextDouble();
        solutionhack2 business = new solutionhack2();
        business.getBooksBelongingToAGenre(books, sg);
        business.calculateDiscountedPrice(books, dg, dp);
    }
}
class Author{
    private int authorid;
    private String authorname;
    public Author(int authorid, String authorname){
        this.authorid = authorid;
        this.authorname = authorname;
    }
    public int getaurthorId(){
        return authorid;
    }
    public String getauthorName(){
        return authorname;
    }
}
class Book{
    int bookid;
    String title;
    String genre;
    double price;
    Author author;
    public Book(int bookid, String title, String genre, double price, Author author){
        this.bookid = bookid;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.author = author;
    }
    public String getGenre(){
        return genre;
    }
    public double getPrice(){
        return price;
    }
    public String getTitle(){
        return title;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public int getId(){
        return bookid;
    }
    public Author getAuthor(){
        return author;
    }
}