import java.io.*;
import java.lang.*;
import java.util.*;

class Book implements Serializable {
    public String name;
    public String author;
    public double price;
    public String type;

    public Book(String n, String a, double p, String t) {
        name = n;
        author = a;
        price = p;
        type = t;
    }

    public void set_values(String n, String a, double p, String t) {
        name = n;
        author = a;
        price = p;
        type = t;
    }

    public void print_book() {
        System.out.println("Book Name: " + name + "    ");
        System.out.print("Author: " + author + "    ");
        System.out.print("Price: " + price + "    ");
        System.out.print("Type: " + type);
    }
}

class NameComparator implements Comparator<Book> {

    @Override
    public int compare(Book a, Book b) {
        return a.name.compareTo(b.name);
    }
}

class PriceComparator implements Comparator<Book> {

    @Override
    public int compare(Book a, Book b) {
        if (a.price < b.price){
            return -1;
        }
        else if (b.price < a.price){
            return 1;
        }
        return 0;
    }
}

public class BookArrayList {
    public static void main(String[] args) {
        ArrayList<Book> sciencefiction = new ArrayList<Book>();
        ArrayList<Book> comedy = new ArrayList<Book>();
        ArrayList<Book> thriller = new ArrayList<Book>();

        System.out.println("Books in the sciencefiction list:");
        print_book(sciencefiction);

        System.out.println("Books in the comedy list:");
        print_book(comedy);

        System.out.println("Books in the thriller list:");
        print_book(thriller);

        sort_books();
    }

    static void sort_books() {
        System.out.println("Sorting sciencefiction list based on names:");
    }

    static void print_book(ArrayList<Book> books) {
        for (Book b : books) {
            b.print_book();
        }
    }
}