package bookstore;

/**
 * Represents a DVD
 * 
 * @author nanajjar
 */
public class DVD {

    private String name;
    private String category;
    private double price;
    private int stock;
    /**
     * Constructor for DVD class
     *
     * @param name the title of this DVD
     * @param category the category of this DVD
     * @param price the price of this DVD
     * @param stock the amount of this item in stock
     */
    public DVD(String name,String category,double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Get the value of category
     *
     * @return the value of category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set the value of category
     *
     * @param category new value for category
     */
    public void setCategory(String category) {
        this.category = category;
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
     * @param name new value for name
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
     * @param price new value for price
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
     * @param stock new value for stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

}
