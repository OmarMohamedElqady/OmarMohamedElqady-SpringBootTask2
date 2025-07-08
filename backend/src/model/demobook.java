package model;

public class demobook extends Book{
    public demobook(String isbn, String title, int year, double price) {
        super(isbn, title, year, price);
        // Price might be 0 or a nominal value, but the key is it's marked as demo.
    }

    @Override
    public String toString() {
        return super.toString() + " (Demo - Not for Sale)";
    }

    @Override
    public String getType() {
        return "demobook";
    }
}

