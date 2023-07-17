package bookstore;

/**
 * Represents a CD
 * 
 * @author nanajjar
 */
public class CD {

    private String name;
    private String artist;
    private double price;
    private int stock;

    /**
     * Constructor for CD class
     * 
     * @param name the name or title of the product
     * @param artist artist or band name as a String
     * @param price the price of the product
     * @param stock the amount of this product currently in stock
     */
    public CD(String name, String artist, double price, int stock) {
        this.name = name;
        this.artist = artist;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Gets the value of the artist field.
     *
     * @return the artist or band's name
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Sets the artist field with the given value
     *
     * @param artist the artist or band's name
     */
    public void setArtist(String artist) {
        this.artist = artist;
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
