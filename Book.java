package bookstore;

/**
 * Represents a book
 * 
 * @author nanajjar
 */
public class Book{

    private String name;
    private String author;
    private double price;
    private int stock;

    /**
     * Book constructor
     *
     * @param name the book's title
     * @param author the author of the book
     * @param price the price of the book
     * @param stock number of copies in stock
     */
    public Book(String name, String author, double price, int stock) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Getting for author field
     *
     * @return the value of author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Setting for author field
     *
     * @param author the author  
     */
    public void setAuthor(String author) {
        this.author = author;
    }

   /**
     * Getting for name field
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setting for name field
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

     /**
     * Getting for price field
     *
     * @return the value of price
     */

    public double getPrice() {
        return price;
    }

    /**
     * Setting for price field
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    /**
     * Getting for stock field
     *
     * @return the value of stock
     */

    public int getStock() {
        return stock;
    }

     /**
     * Setting for stock field
     *
     * @param stock the stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

}
