package bookstore;

/**
 * Represents a premium member customer
 * @author nanajjar
 */
public class PremiumMember {

    private String name;
    private int numPurchases;
    private boolean hasPaidDues;

    /**
     * Constructor for the PremiumMember class
     *
     *
     * @param name the name of this Member
     * @param numPurchases the number of purchases this member has made
     * @param hasPaidDues boolean for whether or not a member has made the
     * premium membership fee
     */
    public PremiumMember(String name, int numPurchases, boolean hasPaidDues) {
        this.name = name;
        this.numPurchases = numPurchases;
        this.hasPaidDues = hasPaidDues;
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

    /**
     * setter for changing whether or not a member has paid their membership fee
     *
     * @param hasPaidDues boolean, true if they have paid the fee
     */
    public void setHasPaidDues(boolean hasPaidDues) {
        this.hasPaidDues = hasPaidDues;
    }

    /**
     * getter for checking if a member has paid the membership fee
     *
     * @return true if dues have been paid, false if they haven't
     */
    public boolean hasPaidDues() {
        return hasPaidDues;
    }

}
