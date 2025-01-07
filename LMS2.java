import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;

class Library {
    private ArrayList<String> Books;

    public Library() {
        Books = new ArrayList<>(Arrays.asList("To Kill a Mockingbird", "1984", "Pride and Prejudice", "The Great Gatsby", "Siddhartha", "Beloved", "Hamlet", "Dracula", "Emma", "Coraline"));
    }

    public void manageLibrary() {
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss a");
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to this Library..! How can I help you?");
            System.out.println("Enter your Name:");
            String name = sc.nextLine().trim();
            if (name.isEmpty()) 
            {
                System.out.println("Name cannot be empty!");
                return;
            }
            System.out.println("\nChoose 1 to Know Available Books \nChoose 2 to Add Books \nChoose 3 to Return Book");
            int action = sc.nextInt();
            sc.nextLine();

            switch(action) 
            {
                case 1:
                    System.out.println("Available Books are:\n");
                    for (String book : Books) 
                    {
                        System.out.println(book);
                    }
                    break;

                case 2:
                    try 
                    {
                    System.out.println("Enter how many books you want to add:");
                    int numBooksToAdd = sc.nextInt();
                    sc.nextLine();
                    if (numBooksToAdd <= 0) 
                    {
                        System.out.println("Number of books should be a positive integer.");
                        return;
                    }
                    System.out.println("Enter book names one by one:");
                    for (int i = 0; i < numBooksToAdd; i++) 
                    {
                    String bookName = sc.nextLine().trim();
                    if (!bookName.isEmpty()) 
                    {
                        Books.add(bookName);
                    } 
                    else 
                    {
                            System.out.println("Book name cannot be empty!");
                    }
                    }
                    System.out.println("Books available after adding are:\n");
                    for (String book : Books) 
                    {
                            System.out.println(book);
                    }

                    } 
                    catch (java.util.InputMismatchException e) 
                    {
                        System.out.println("Enter a valid integer for the number of books.");
                        sc.next(); 
                    }
                    break;

                case 3:
                    try {
                        System.out.println("Enter the name of the book to return:");
                        String bookName = sc.nextLine().trim();
                        boolean found = false;
                        for (int i = 0; i < Books.size(); i++)
                        {
                            if (Books.get(i).equalsIgnoreCase(bookName)) 
                            {
                                Books.remove(i);
                                found = true;
                                break;
                            }
                        }
                        if (found) 
                        {
                            System.out.println("The book \"" + bookName + "\" has been successfully returned by " + name + ".");
                            System.out.println("Book was returned on: " + sdf.format(date));
                        } 
                        else 
                        {
                            System.out.println("Book not found.");
                        }

                    } 
                    catch (java.util.InputMismatchException e) 
                    {
                        System.out.println("Enter a valid book name in string format.");
                    } 
                    finally 
                    {
                        System.out.println("Books available after return are:\n" + Books);
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                    break;
            }

        }
         catch (java.util.InputMismatchException e)
        {
            System.out.println("You have to enter an integer.");
        }
    }
}

public class LMS2 {
    public static void main(String[] args) {
        Library library = new Library();
        library.manageLibrary();
    }
}
