package service;
import model.Book;
import model.Paperbook;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


public class inventory {
    private Map<String, Book> books;

    public inventory() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            System.out.println("Error: Book with ISBN " + book.getIsbn() + " already exists.");
            return;
        } else {
            books.put(book.getIsbn(), book); // Add the book using its ISBN as the key
            System.out.println("Added: " + book.getTitle() + " (ISBN: " + book.getIsbn() + ") to inventory.");
        }
    }

    public Book getBook(String isbn) {
        return books.get(isbn);
    }

    public Book removeBook(String isbn) {
        if (books.containsKey(isbn)) {
            Book removedBook = books.remove(isbn); // Remove and return the book
            System.out.println("Removed: " + removedBook.getTitle() + " (ISBN: " + isbn + ") from inventory.");
            return removedBook;
        } else {
            System.out.println("Error: Book with ISBN " + isbn + " not found in inventory.");
            return null;
        }
    }

    public void removeOutdatedBooks(int yearsOld) {
        int currentYear = Year.now().getValue(); // Get the current year (e.g., 2025)
        List<String> isbnsToRemove = new ArrayList<>(); // A temporary list to hold ISBNs of outdated books

        // Iterate through all books in the inventory
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            Book book = entry.getValue();
            if ((currentYear - book.getYear()) > yearsOld) {
                isbnsToRemove.add(book.getIsbn()); // Add its ISBN to our removal list
            }
        }
        if (isbnsToRemove.isEmpty()) {
            System.out.println("No books older than " + yearsOld + " years found to remove.");
            return;
        }
        System.out.println("Removing books older than " + yearsOld + " years:");
        // Now, remove the books using the ISBNs collected in the temporary list
        for (String isbn : isbnsToRemove) {
            removeBook(isbn);
        }
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("\n--- Current Inventory ---");

        for (Book book : books.values()) {
            System.out.println(book);
        }
        System.out.println("-------------------------\n");
    }
}
