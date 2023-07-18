package bookstore;

public class Book extends Product {
    private String author;

    public Book(String name, String author, double price, int stock) {
        super(name, price, stock);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
