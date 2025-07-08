

// Import statements still use standard Java PascalCase for class names
import model.*;
import service.*;



public class Main {
    public static void main(String[] args) {
        System.out.println("   --- Welcome to Quantum Bookstore ---");

        inventory myinventory = new inventory();
        shippingService myshippingService = new shippingService();
        mailService mymailService = new mailService();

        customerActions mycustomeractions = new customerActions(myinventory, myshippingService, mymailService);

        System.out.println("\n   ---* Adding Books *---");
        Paperbook paperbook1 = new Paperbook("978-1234567891", "The Martian", 2011, 18.50, 15);
        ebook ebook1 = new ebook("978-9876543210", "Data Structures Fundamentals", 2022, 22.99, "PDF");
        Paperbook paperBook2 = new Paperbook ("978-1122334455", "Dune", 1965, 15.00, 8);
        demobook demobook1 = new demobook("DEMO-007", "AI Ethics Preview", 2024, 0.00);
        ebook ebook2 = new ebook("978-5554443332", "Cybersecurity Basics", 2023, 35.00, "EPUB");

        myinventory.addBook(paperbook1);
        myinventory.addBook(ebook1);
        myinventory.addBook(paperBook2);
        myinventory.addBook(demobook1);
        myinventory.addBook(ebook2);

        myinventory.addBook(new Paperbook("978-1234567891", "Duplicate Martian", 2005, 10.00, 1));
        myinventory.displayAllBooks();

        System.out.println("\n   ---* Simulating Purchases *---");
        customerActions.purchaseResult result;

        System.out.println("\n     --- Purchasing Scenario: Initial Paper Book ---");
        result = mycustomeractions.buysinglebook(
                "978-1234567891",
                2,
                null,
                "10 Downing St, London"
        );
        if (result.success) {
            System.out.println(String.format("   Purchase successful! Total paid: $%.2f", result.amountPaid));
        } else {
            System.out.println("   Purchase failed: " + result.message);
        }

        System.out.println("\n     --- Purchasing Scenario: Initial EBook ---");
        result = mycustomeractions.buysinglebook(
                "978-9876543210",
                1,
                "reader@example.com",
                null
        );
        if (result.success) {
            System.out.println(String.format("   Purchase successful! Total paid: $%.2f", result.amountPaid));
        } else {
            System.out.println("   Purchase failed: " + result.message);
        }

        System.out.println("\n     --- Purchasing Scenario: Initial Out of Stock ---");
        result = mycustomeractions.buysinglebook(
                "978-1122334455", 10, null, "221B Baker St, London"
        );
        if (result.success) {
            System.out.println(String.format("   Purchase successful! Total paid: $%.2f", result.amountPaid));
        } else {
            System.out.println("   Purchase failed: " + result.message);
        }

        System.out.println("\n     --- Purchasing Scenario: Demo Book ---");
        result = mycustomeractions.buysinglebook(
                "DEMO-007", 1, "demo@user.com", null
        );
        if (result.success) {
            System.out.println(String.format("   Purchase successful! Total paid: $%.2f", result.amountPaid));
        } else {
            System.out.println("   Purchase failed: " + result.message);
        }

        System.out.println("\n     --- Purchasing Scenario: Non-existent Book ---");
        result = mycustomeractions.buysinglebook(
                "NONEXIST-001", 1, null, "1 Testing Way, Failsville"
        );
        if (result.success) {
            System.out.println(String.format("   Purchase successful! Total paid: $%.2f", result.amountPaid));
        } else {
            System.out.println("   Purchase failed: " + result.message);
        }

        System.out.println("\n     --- Purchasing Scenario: EBook No Email ---");
        result = mycustomeractions.buysinglebook(
                "978-5554443332", 1, null, null
        );
        if (result.success) {
            System.out.println(String.format("   Purchase successful! Total paid: $%.2f", result.amountPaid));
        } else {
            System.out.println("   Purchase failed: " + result.message);
        }

        System.out.println("\n   ---* Extended Purchase Scenarios *---");

        System.out.println("\n     --- Scenario 7: Buy 3 copies of The Martian ---");
        result = mycustomeractions.buysinglebook(
                "978-1234567891",
                3,
                null,
                "707 Space Rd, Orbit City"
        );
        if (result.success) {
            System.out.println(String.format("   Purchase successful! Total paid: $%.2f", result.amountPaid));
        } else {
            System.out.println("   Purchase failed: " + result.message);
        }
        System.out.println("\n     --- Inventory after Scenario 7 ---");
        myinventory.displayAllBooks();

        System.out.println("\n     --- Scenario 8: Buy remaining 8 copies of Dune ---");
        result = mycustomeractions.buysinglebook(
                "978-1122334455",
                8,
                null,
                "1 Caladan Ave, Arrakis"
        );
        if (result.success) {
            System.out.println(String.format("   Purchase successful! Total paid: $%.2f", result.amountPaid));
        } else {
            System.out.println("   Purchase failed: " + result.message);
        }
        System.out.println("\n     --- Inventory after Scenario 8 ---");
        myinventory.displayAllBooks();

        System.out.println("\n     --- Scenario 9: Buy Dune (now out of stock) ---");
        result = mycustomeractions.buysinglebook(
                "978-1122334455",
                1,
                null,
                "101 Sandworm Way, Desert"
        );
        if (result.success) {
            System.out.println(String.format("   Purchase successful! Total paid: $%.2f", result.amountPaid));
        } else {
            System.out.println("   Purchase failed: " + result.message);
        }

        System.out.println("\n     --- Scenario 10: Buy with Zero Quantity ---");
        result = mycustomeractions.buysinglebook(
                "978-9876543210",
                0,
                "zero.qty@example.com",
                null
        );
        if (result.success) {
            System.out.println(String.format("   Purchase successful! Total paid: $%.2f", result.amountPaid));
        } else {
            System.out.println("   Purchase failed: " + result.message);
        }

        System.out.println("\n     --- Scenario 11: Buy with Negative Quantity ---");
        result = mycustomeractions.buysinglebook(
                "978-9876543210",
                -5,
                "negative.qty@example.com",
                null
        );
        if (result.success) {
            System.out.println(String.format("   Purchase successful! Total paid: $%.2f", result.amountPaid));
        } else {
            System.out.println("   Purchase failed: " + result.message);
        }

        System.out.println("\n     --- Scenario 12: Re-add The Martian ---");
        myinventory.addBook(new Paperbook("978-1234567891", "The Martian (Duplicate)", 2020, 10.00, 1));


        System.out.println("\n   ---* Inventory Management *---");
        myinventory.displayAllBooks();

        System.out.println("\n     --- Removing Outdated Books (older than 50 years) ---");
        myinventory.removeOutdatedBooks(50);

        System.out.println("\n     --- Removing a specific book (Data Structures Fundamentals) ---");
        myinventory.removeBook("978-9876543210");
        myinventory.displayAllBooks();

        System.out.println("\n   --- Quantum Bookstore Operations Complete ---");
    }
}
