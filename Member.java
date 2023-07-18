package bookstore;

/**
 * Represents a member customer
 * @author nanajjar
 */
public class Member {

    private String name;
    private int numPurchases;

    /**
     * Constructor for the Member class
     *
     * @param name the name of this Member
     * @param numPurchases the number of purchases this member has made
     */
    public Member(String name, int numPurchases) {
        this.name = name;
        this.numPurchases = numPurchases;
    }

    /**
     * Getter for the name field
     *
     * @return the name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name field
     *
     * @param name the member's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for the number of purchases a member has made
     *
     * @return the number of purchases a member has made
     */
    public int getNumPurchases() {
        return numPurchases;
    }

    /**
     * setter for the number of purchases by a member
     *
     * @param numPurchases the number of purchases by this member
     */
    public void setNumPurchases(int numPurchases) {
        this.numPurchases = numPurchases;
    }

    /**
     * a method to increment the number of purchases by a set amount
     *
     * @param numPurchases the number of new purchases made by this member
     */
    public void incrementPurchases(int numPurchases) {
        this.numPurchases += numPurchases;
    }

}
