import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Class to represent a Book in the library.
class Book {
    private String title;
    private String author;
    private int quantity;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int amount) {
        this.quantity += amount;
    }
    
    public boolean borrow(int amount) {
        if (this.quantity >= amount) {
            this.quantity -= amount;
            return true;
        } else {
            return false;
        }
    }
    
    public void returnBook(int amount) {
        this.quantity += amount;
    }
}

public class LibrarySystem {
    // Map to store books with the title as the key.
    private static Map<String, Book> library = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {
            System.out.println("\n--- Library System ---");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // Read user input and handle non-integer inputs.
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }
            
            switch (choice) {
                case 1:
                    addBooks(scanner);
                    break;
                case 2:
                    borrowBooks(scanner);
                    break;
                case 3:
                    returnBooks(scanner);
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye! Stay awesome.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Option 1: Add Books to the library.
    private static void addBooks(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println("Book title cannot be empty.");
            return;
        }

        System.out.print("Enter book author: ");
        String author = scanner.nextLine().trim();
        if (author.isEmpty()) {
            System.out.println("Book author cannot be empty.");
            return;
        }

        System.out.print("Enter quantity: ");
        int quantity;
        try {
            quantity = Integer.parseInt(scanner.nextLine());
            if (quantity <= 0) {
                System.out.println("Quantity must be a positive number");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity input.");
            return;
        }
        
        if (library.containsKey(title)) {
            // If the book already exists, update the quantity.
            Book existingBook = library.get(title);
            existingBook.addQuantity(quantity);
            System.out.println("Updated quantity of '" + title + "' by " + quantity + ".");
        } else {
            // Otherwise, add a new book to the library.
            Book newBook = new Book(title, author, quantity);
            library.put(title, newBook);
            System.out.println("Added new book: '" + title + "' by " + author + " with quantity: " + quantity + ".");
        }
    }

    // Option 2: Borrow Books from the library.
    private static void borrowBooks(Scanner scanner) {
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine().trim();
        if (!library.containsKey(title)) {
            System.out.println("Book not found in the library!");
            return;
        }
        
        Book book = library.get(title);
        System.out.print("Enter number of copies to borrow: ");
        int numToBorrow;
        try {
            numToBorrow = Integer.parseInt(scanner.nextLine());
            if (numToBorrow <= 0) {
                System.out.println("Number must be a positive integer.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input.");
            return;
        }
        
        if (book.borrow(numToBorrow)) {
            System.out.println("Successfully borrowed " + numToBorrow + " copies of '" + title + "'. Enjoy reading!");
        } else {
            System.out.println("Not enough copies available. Only " + book.getQuantity() + " left!");
        }
    }

    // Option 3: Return Books to the library.
    private static void returnBooks(Scanner scanner) {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine().trim();
        if (!library.containsKey(title)) {
            System.out.println("This book doesn't belong to our library!");
            return;
        }
        
        Book book = library.get(title);
        System.out.print("Enter number of copies to return: ");
        int numToReturn;
        try {
            numToReturn = Integer.parseInt(scanner.nextLine());
            if (numToReturn <= 0) {
                System.out.println("Number must be a positive integer.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input.");
            return;
        }
        
        book.returnBook(numToReturn);
        System.out.println("Successfully returned " + numToReturn + " copies of '" + title + "'. Thanks for keeping our library stocked!");
    }
}
