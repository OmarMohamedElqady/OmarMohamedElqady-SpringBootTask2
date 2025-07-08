package service;
import  model.Book;
public class mailService {

    public void sendEbook(Book book,String email) {
        System.out.println(String.format("Simulating: Sending EBook '%s' (ISBN: %s, Type: %s) to %s",
                book.getTitle(), book.getIsbn(), book.getType(), email));
    }
}
