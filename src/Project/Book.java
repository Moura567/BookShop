import java.util.*;

public class Book {
    Scanner s = new Scanner(System.in);
    static ArrayList<Book> arr = new ArrayList(100);
    private String name;
    private String author;
    private double price;

    public Book() {
    }

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public ArrayList<Book> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Book> arr) {
        this.arr = arr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
 public static void display() {
        ArrayList<Book> listBook = Book.arr;
        if (Book.arr.isEmpty()) {
            System.out.println("There is no books to display");
        } else {
            System.out.println("Book name " + "    " + "Book author " + "    " + "Book price ");
            for (Book book : listBook) {
                System.out.println(" " + book.getName() + "\t" + "\t" + "\t" + book.getAuthor() + "\t" + "\t" + "\t" + book.getPrice());
            }
        }
    }
    public static boolean add(Scanner s) {
        String j = null;
        boolean option = true;
        double price = 0;
        int num = 0;
        System.out.println("Are you sure to add books yes or no ?");
        j = s.next();
        while (option){
            if (j.equalsIgnoreCase("yes")) {
                try {
                    System.out.println("Enter number of books");
                    num = s.nextInt();
                } catch (Exception e) {
                    System.out.print("Wrong number please try again :");
                    s.next();
                    num = s.nextInt();
                }
                for (int i = 0; i < num; i++) {
                    System.out.print("Book name " + (i + 1) + " : ");
                    String name = s.next();
                    System.out.print("Book author " + (i + 1) + " : ");
                    String author = s.next();
                    System.out.print("Book price " + (i + 1) + " : ");
                    try {
                        price = s.nextDouble();
                    } catch (Exception e) {
                        System.out.print("Wrong price try again: ");
                        s.next();
                        price = s.nextDouble();
                    }
                    System.out.println("Book added successfully ");
                    Book b = new Book();
                    b.setName(name);
                    b.setAuthor(author);
                    b.setPrice(price);
                    Book.arr.add(b);
                    option = false;
                }
            } else if (j.equalsIgnoreCase("no")) {
                return true;
            } else {
                System.out.println("please enter yes or no");
                j = s.next();
            }
        }
        return false;
    }
    public static Book getBookByName(String s) {
        for (Book book : arr) {
            if (book.name.equalsIgnoreCase(s)) {
                return book;
            }
        }
        return null;
    }

    public static Book search(String s) {
        for (Book book : arr) {
            if (book.name.equalsIgnoreCase(s)) {
                System.out.println("Book name " + "    " + "Book author " + "    " + "Book price ");
                System.out.println(" " + book.getName() + "\t" + "\t" + "\t" + book.getAuthor() + "\t" + "\t" + "\t" + book.getPrice());
                return book;
            }
        }
        return null;
    }

    public static void updateBook(Book newBook, Book oldBook) {
        if (arr.size() > 0) {
            int x = arr.size();
            int index = 5;

            for (int i = 0; i < x; i++) {
                if (arr.get(i).getName().equalsIgnoreCase(oldBook.getName())) {
                    index = i;
                    break;
                }

            }
            if (index != 5) {
                arr.get(index).setName(newBook.getName());
                arr.get(index).setAuthor(newBook.getAuthor());
                arr.get(index).setPrice(newBook.getPrice());
            }
        }
    }

    public static void newName(Scanner s) {
        System.out.print("Enter book name to update : ");
        String n = s.next();
        Book oldBook = Book.getBookByName(n);
        Book newBook = Book.getBookByName(n);
        Book.getBookByName(n);
        if (oldBook == null) {
            System.out.println("Not founded");
        } else {
            System.out.print("Enter new name :");
            String f = s.next();
            newBook.setName(f);
            Book.updateBook(newBook, oldBook);
            System.out.println("Updated successfully");
        }
    }

    public static void newAuthor(Scanner s) {
        System.out.print("Enter book name to update : ");
        String n = s.next();
        Book oldBook = Book.getBookByName(n);
        Book newBook = Book.getBookByName(n);
        Book.getBookByName(n);
        if (oldBook == null) {
            System.out.println("Not founded");
        } else {
            System.out.print("Enter new author :");
            String w = s.next();
            newBook.setAuthor(w);
            Book.updateBook(newBook, oldBook);
            System.out.println("Updated successfully");
        }
    }

    public static void newPrice(Scanner s) {
        System.out.print("Enter book name to update : ");
        String n = s.next();
        double t=0;
        Book oldBook = Book.getBookByName(n);
        Book newBook = Book.getBookByName(n);
        Book.getBookByName(n);
        if (oldBook == null) {
            System.out.println("Not founded");
        } else {

            try {
                System.out.print("Enter new price :");
                t = s.nextDouble();
            } catch (Exception e) {
                System.out.print("Wrong price try again: ");
                s.next();
                t = s.nextDouble();
            }
            newBook.setPrice(t);
            Book.updateBook(newBook, oldBook);
            System.out.println("Updated successfully");

        }


    }

    public static void delete(Scanner s) {
        System.out.print("Enter book name to delete : ");
        String n = s.next();
        Book book = getBookByName(n);
        book.getBookByName(n);
        if (book == null) {
            System.out.println("Not founded");
        } else {
            Book.arr.remove(book);
            System.out.println("Deleted successfully");

        }
    }

    public static boolean check() {
        if (arr.isEmpty()) {
            System.out.println("There is no books");
            return false;
        }
        return true;
    }
}