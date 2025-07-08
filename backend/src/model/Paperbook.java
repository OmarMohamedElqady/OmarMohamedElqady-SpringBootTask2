package model;

public class Paperbook extends Book{

    private int stock;


    public Paperbook(String isbn, String title, int year, double price, int stock) {
        super(isbn, title, year, price);
        this.stock = stock;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void decreaseStock(int quantity){
        if (this.stock >= quantity) {
            this.stock -= quantity;
        } else {
            System.out.println("Sorry stock exceeded");
        }
    }

    @Override
    public String toString() {
        return super.toString()+ ", Stock: " + stock;
    }
    @Override
    public String getType() {
        return "PaperBook";
    }
}
