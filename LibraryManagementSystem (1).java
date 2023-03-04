import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int id;
    private boolean isAvailable;

    public Book(String title, String author, int id, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<Book>();

    public void addBook(String title, String author, int id, boolean isAvailable) {
        Book newBook = new Book(title, author, id, isAvailable);
        books.add(newBook);
    }

    public void removeBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                books.remove(book);
                System.out.println("Book removed.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("ID: " + book.getId());
            System.out.println("Available: " + book.getIsAvailable());
            System.out.println();
        }
    }

    public void checkoutBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                if (book.getIsAvailable()) {
                    book.setIsAvailable(false);
                    System.out.println("Book checked out.");
                    return;
                } else {
                    System.out.println("Book not available.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                if (!book.getIsAvailable()) {
                    book.setIsAvailable(true);
                    System.out.println("Book returned.");
                    return;
                } else {
                    System.out.println("Book already available.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter an option:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Display all books");
            System.out.println("4. Checkout a book");
            System.out.println("5. Return a book");
            System.out.println("6. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter title:");
                    String title = scanner.next();
                    System.out.println("Enter author:");
                    String author = scanner.next();
                    System.out.println("Enter ID:");
                    int id = scanner.nextInt();
                    library.addBook(title, author, id, true);
                    break;
                case 2:
                    System.out.println("Enter ID:");
                    int removeId = scanner.nextInt();
                    library.removeBook(removeId);
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    System.out.println("Enter ID:");
                    int checkoutId = scanner.nextInt();
                    library.checkoutBook(checkoutId);
                    break;
                case 5:
                    System.out.println("Enter ID:");
                    int returnId = scanner.nextInt();
                    library.returnBook(returnId);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

