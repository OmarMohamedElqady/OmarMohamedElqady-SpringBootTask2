package service;
import model.Book;
public class shippingService {
    public void shipbook(Book book, int quantity, String username) {
        System.out.println(String.format("Simulating: Shipping %d copies of '%s' (ISBN: %s) to %s",
                quantity, book.getTitle(), book.getIsbn(), username));

    }
}
