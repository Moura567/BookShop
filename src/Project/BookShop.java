
import java.util.Scanner;

public class BookShop {

    public static void menu() {
        System.out.print(" 1 - Disply " + "\n" + " 2 - Add book" + "\n"
                + " 3 - Update book" + "\n" + " 4 - Delete book" + "\n"
                + " 5 - Search book" + "\n" + " 6 - Exit" + "\n" + "Choose : ");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int updateChoice, choice = 0;
        boolean error = false;
        do {
            error = false;
            menu();
            try {
                switch (choice = s.nextInt()) {
                    case 1:
                        Book.display();
                        break;
                    case 2:
                        Book.add(s);
                        break;
                    case 3:
                        boolean check = true;
                        if (Book.check()) {
                            while (check) {
                                System.out.println(" 1 - Update book name " + "\n" + " 2 - Update book Author " + "\n"
                                        + " 3 - Update book price" + "\n" + " 4 - Back" + "\n" + " 5 - Exit" + "\n");
                                System.out.print("Enter choice :");
                                updateChoice = s.nextInt();
                                switch (updateChoice) {
                                    case 1:
                                        Book.newName(s);
                                        break;
                                    case 2:
                                        Book.newAuthor(s);
                                        break;
                                    case 3:
                                        Book.newPrice(s);
                                        break;
                                    case 4:
                                        check = false;
                                        break;
                                    case 5:
                                        System.exit(5);
                                        break;
                                }
                            }
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (Book.check()) {
                            Book.delete(s);
                            break;

                        } else {
                            break;
                        }
                    case 5:
                        if (Book.check()) {
                            System.out.print("Enter book name : ");
                            String g = s.next();
                            Book.search(g);
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        System.exit(5);
                        break;

                }
            } catch (Exception e) {
                System.out.println("Wrong choice , the program will back to main menu if you need to use the program choose a valid option");
                s.next();
            }
        } while (error == false);
    }
}
