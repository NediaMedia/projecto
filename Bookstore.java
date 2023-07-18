package bookstore;

import java.util.ArrayList;

/**
 * Handles bookstore setup
 * tracking inventory and members 
 *
 * @author nanajjar
 */
public class Bookstore {

    ArrayList<Book> bookInventory = new ArrayList();
    ArrayList<CD> cdInventory = new ArrayList();
    ArrayList<DVD> dvdInventory = new ArrayList();
    ArrayList<Member> membersList = new ArrayList();
    ArrayList<PremiumMember> premiumMembersList = new ArrayList();

    /**
     * Constructor. Calls helper methods that generate lists of the different
     * products and different members (starting inventory and members)
     */
    public Bookstore() {
        generateInventory();
        generateMembers();
    }

    // helper method to generate staring inventory of products
    private void generateInventory() {
        Book book1 = new Book("To Kill A Mockingbird", "Harper Lee", 9.99, 2);
        Book book2 = new Book("Charlotte's Web", "E.B. White", 7.99, 7);
        CD cd1 = new CD("Cuz I Love You", "Lizzo", 7.99, 5);
        DVD dvd1 = new DVD("How To Train Your Dragon", "Movie", 15.99, 3);

        bookInventory.add(book1);
        bookInventory.add(book2);
        cdInventory.add(cd1);
        dvdInventory.add(dvd1);
    }

    // helper method to generate staring members
    private void generateMembers() {
        Member member1 = new Member("Steve", 5);
        PremiumMember member2 = new PremiumMember("Jessica", 3, true);
        PremiumMember member3 = new PremiumMember("Malik", 100, false);

        membersList.add(member1);
        premiumMembersList.add(member2);
        premiumMembersList.add(member3);
    }

    /**
     * getter for book inventory
     *
     * @return arraylist of books
     */
    public ArrayList<Book> getBookInventory() {
        return bookInventory;
    }

    /**
     * getter for dvd inventory
     *
     * @return arraylist of DVDs
     */
    public ArrayList<DVD> getDvdInventory() {
        return dvdInventory;
    }

    /**
     * getter for CD inventory
     *
     * @return arraylist of CDs
     */
    public ArrayList<CD> getCdInventory() {
        return cdInventory;
    }

    /**
     * getter for members list
     *
     * @return arraylist of Members
     */
    public ArrayList<Member> getMembersList() {
        return membersList;
    }

    /**
     * getter for premium members list
     *
     * @return arraylist of premium members
     */
    public ArrayList<PremiumMember> getPremiumMembersList() {
        return premiumMembersList;
    }

    /**
     * update inventory - subtract 1 from current system currently allows
     * customer to add items to cart one at a time
     *
     * @param id menu selection number
     */
    public void decrementInventory(int id) {
        int current; //to hold current amount
        if (id <= bookInventory.size()) {
            current = bookInventory.get(id - 1).getStock();
            if (current == 1) {
                bookInventory.remove(id - 1);
            } else {
                bookInventory.get(id - 1).setStock(current - 1);
            }
        } else if (id <= bookInventory.size() + cdInventory.size()) {
            id = id - bookInventory.size();
            current = cdInventory.get(id - 1).getStock();
            if (current == 1) {
                cdInventory.remove(id - 1);
            } else {
                cdInventory.get(id - 1).setStock(current - 1);
            }
        } else {
            id = id - (bookInventory.size() + cdInventory.size());
            current = dvdInventory.get(id - 1).getStock();
            if (current == 1) {
                dvdInventory.remove(id - 1);
            } else {
                dvdInventory.get(id - 1).setStock(current - 1);
            }
        }
    }

    /**
     * method that creates the cart entry for a selected product
     *
     * @param id identifier for product selected by user
     * @return a string containing product name and price following this format:
     * productName - productPrice
     */
    public String getCartItem(int id) {
        String cartItem = "";
        if (id <= bookInventory.size()) {
            cartItem = bookInventory.get(id - 1).getName() + " - " + bookInventory.get(id - 1).getPrice();

        } else if (id <= bookInventory.size() + cdInventory.size()) {
            id = id - bookInventory.size();
            cartItem = cdInventory.get(id - 1).getName() + " - " + cdInventory.get(id - 1).getPrice();

        } else {
            id = id - (bookInventory.size() + cdInventory.size());
            cartItem = dvdInventory.get(id - 1).getName() + " - " + dvdInventory.get(id - 1).getPrice();
        }
        return cartItem;
    }

    /**
     * Adds a new member to the members arraylist
     *
     * @param name member's name as a String
     * @param premium whether or not the new member should be a premium or free
     * member
     * @param numOfItems number of items to start member profile with 
     */
    public void addNewMember(String name, boolean premium, int numOfItems) {
        if (premium) {
            if (numOfItems == 0) {
                // registration only
                premiumMembersList.add(new PremiumMember(name, numOfItems, false));
            } else {
                // registration with checkout
                premiumMembersList.add(new PremiumMember(name, numOfItems, true));
            }

        } else {
            membersList.add(new Member(name, numOfItems));
        }
    }

    /**
     * method to check and display member profile
     * @param memberId  identifier for member selected by user
     */
    public void displayMemberStatus(int memberId) {
        // need to detrmine member type to know which list to look in
        System.out.println("Member details:");
        if (memberId <= membersList.size()) {
            Member chosenMember = membersList.get(memberId - 1);
            System.out.println("\tName: " + chosenMember.getName());
            System.out.println("\tNumber of items purchased: " + chosenMember.getNumPurchases());
            System.out.println("\tStatus: Free Tier");
        } else {
            PremiumMember chosenMember = premiumMembersList.get(memberId - membersList.size() - 1);
            System.out.println("\tName: " + chosenMember.getName());
            System.out.println("\tNumber of items purchased: " + chosenMember.getNumPurchases());
            System.out.println("\tStatus: Premium");
            System.out.println(
                    "\tMembership dues paid: " + chosenMember.hasPaidDues());
        }
    }
}
