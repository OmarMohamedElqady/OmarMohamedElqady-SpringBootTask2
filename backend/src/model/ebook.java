package model;

public class ebook extends Book {
    private String filetype;
    public ebook(String isbn, String title, int year, double price, String filetype) {
        super(isbn, title, year, price);
        this.filetype=filetype;
    }
    public String getFiletype() {
        return filetype;}
    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }
    @Override
    public String toString() {
        return super.toString() + ", Filetype: " + filetype;
    }
    @Override
    public String getType() {
        return "EBook";
    }
}
