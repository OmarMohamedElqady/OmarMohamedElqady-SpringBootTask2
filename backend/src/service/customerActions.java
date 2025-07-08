package service;
import model.Book;
import model.Paperbook;
import model.demobook;
import model.ebook;
public class customerActions {

    private inventory inventory;
    private shippingService shippingService;
    private mailService mailService;

    public customerActions(inventory inventory, shippingService shippingService, mailService mailService) {
        this.inventory = inventory;
        this.shippingService = shippingService;
        this.mailService = mailService;

    }
    public purchaseResult buysinglebook(String isbn, int quantity, String email, String username){
        Book book = inventory.getBook(isbn);
        if (book == null) {
            return new purchaseResult(false, 0.0, "Book with ISBN " + isbn + " not found.");
        }
        if (quantity <= 0) {
            return new purchaseResult(false, 0.0, "Quantity must be positive.");
        }
        if (book instanceof demobook) {
            return new purchaseResult(false, 0.0, "'" + book.getTitle() + "' is a demo book and not for sale.");
        }
        double totalPrice = book.getPrice() * quantity;
        if (book instanceof Paperbook) {

            Paperbook paperBook = (Paperbook) book;
            if (paperBook.getStock() < quantity) {
                return new purchaseResult(false, 0.0, "Not enough stock for '" + paperBook.getTitle() + "'. Available: " + paperBook.getStock() + ", Requested: " + quantity);
            }
            if (username == null || username.trim().isEmpty()) {
                return new purchaseResult(false, 0.0, "Address is required for Paper Books.");
            }

            paperBook.decreaseStock(quantity);
            System.out.println(String.format("Successfully purchased %d copies of '%s'. Total: $%.2f",
                    quantity, paperBook.getTitle(), totalPrice));
            shippingService.shipbook(paperBook, quantity, username); // Call the shipping service
            return new purchaseResult(true, totalPrice, "Success");

        } else if (book instanceof ebook) {

            ebook eBook = (ebook) book;
            if (email == null || email.trim().isEmpty()) {
                return new purchaseResult(false, 0.0, "Email is required for EBooks.");
            }

            System.out.println(String.format("Successfully purchased %d copies (digital) of '%s'. Total: $%.2f",
                    quantity, eBook.getTitle(), totalPrice));
            mailService.sendEbook(eBook, email);
            return new purchaseResult(true, totalPrice, "Success");

        } else {

            return new purchaseResult(false, 0.0, "Cannot process purchase for unknown book type: " + book.getClass().getSimpleName());
        }
    }
    public static class purchaseResult {
        public boolean success;
        public double amountPaid;
        public String message;
        public purchaseResult(boolean success, double amountPaid, String message) {
            this.success = success;
            this.amountPaid = amountPaid;
            this.message = message;

        }
    }
}

