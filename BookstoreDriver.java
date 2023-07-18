

import java.util.*;

/**
 * Handles user interaction and feature execution
 * 
 * @author nanajjar
 */
public class BookstoreDriver {

    /**
     * Main method, executes Book Store functions/flow
     *
     * @param args runtime arguments - not used
     */
    public static void main(String[] args) {

        Bookstore bookstore = new Bookstore();

        Scanner scnr = new Scanner(System.in);

        boolean run = true;

        while (run) {

            System.out.println("Welcome to the automated BookStore System!");
            System.out.println("Select from one of the following options:");
            System.out.println("\t1. Make a purchase");
            System.out.println("\t2. Register as a new member.");
            System.out.println("\t3. Check membership status.");
            System.out.println("\t4. Compare two products.");
            System.out.println("\t5. Restock a product.");
            System.out.println("\t6. Display total inventory value.");
            System.out.println("\t7. Exit");

            int choice = scnr.nextInt();

            switch (choice) {
                case 1:
                    purchase(bookstore, scnr, new ArrayList<String>());
                    break;
                case 2:
                    registerNewMember(bookstore, scnr, 0);
                    break;
                case 3:
                    checkMemberStatus(bookstore, scnr);
                    break;
                case 4:
                    compareProducts(bookstore, scnr);
                    break;
                case 5:
                    restockProduct(bookstore, scnr);
                    break;
                case 6:
                    System.out.println("Total inventory value: " + bookstore.inventoryValue());
                    break;
                case 7:
                    run = false;
                    System.out.println("Thank you for shopping at our store. Come back soon!");
                    break;
                default:
                    System.out.println("Invalid input, try again.");
            }
        }

    }

    /**
     * Method to make purchase
     *
     * @param bookstore
     * @param scnr
     * @param purchases
     */
    private static void purchase(Bookstore bookstore, Scanner scnr, ArrayList<String> purchases) {

        System.out.println("Which of the following would you like to purchase?:");
        ArrayList<Book> bookInventory = bookstore.getBookInventory();
        ArrayList<DVD> dvdInventory = bookstore.getDvdInventory();
        ArrayList<CD> cdInventory = bookstore.getCdInventory();

        int itemNum = 1;
        // display inventory menu
        for (Book item : bookInventory) {
            System.out.print("\t" + itemNum + " " + item.getName());
            System.out.print(" by " + ((Book) item).getAuthor() + " - $" + item.getPrice() + " (Book)");
            System.out.println("");
            itemNum++;
        }
        for (CD item : cdInventory) {
            System.out.print("\t" + itemNum + " " + item.getName());
            System.out.print(" by " + ((CD) item).getArtist() + " - $" + item.getPrice() + " (CD)");
            System.out.println("");
            itemNum++;
        }
        for (DVD item : dvdInventory) {
            System.out.print("\t" + itemNum + " " + item.getName());
            System.out.print(" - $" + item.getPrice() + " (DVD)");
            System.out.println("");
            itemNum++;
        }

        // get user selection for product to add arraylist (cart)
        int choice = scnr.nextInt();
        double total = 0;
        if (choice < itemNum) {
            purchases.add(bookstore.getCartItem(choice));
            //update inventory for this item
            bookstore.decrementInventory(choice);
            System.out.println("You have " + purchases.size() + " items in your cart. Are you done shopping?");
            System.out.println("\t1. Yes");
            System.out.println("\t2. No");

            int doneShopping = scnr.nextInt();
            if (doneShopping == 1) {
                checkout(bookstore, scnr, purchases);
            } else if (doneShopping == 2) { // more shopping
                purchase(bookstore, scnr, purchases); // recursively call purchase(...) until done
            } else {
                System.out.println("Invalid Choice.");
            }
        } else {
            System.out.println("Please enter a valid product number. Try again");
            purchase(bookstore, scnr, purchases);
        }

    }

    /**
     * Method to complete purchase
     *
     * @param bookstore
     * @param scnr
     * @param purchases
     */
    private static void checkout(Bookstore bookstore, Scanner scnr, ArrayList<String> purchases) {

        // calculate total
        double total = getTotalPurchase(purchases);

        System.out.println("Your total comes to " + total + ". \nPlease select which member is making this purchase.");

        // list members and option to register
        int num = 1;
        for (Member member : bookstore.getMembersList()) {
            System.out.println(num + ". " + member.getName());
            num++;
        }
        for (PremiumMember pMember : bookstore.getPremiumMembersList()) {
            System.out.println(num + ". " + pMember.getName());
            num++;
        }
        System.out.println(num + ". Register a new Member.");

        System.out.println(""); // space line
        int memberSelect = scnr.nextInt();
        Member customer = null;

        if (memberSelect > bookstore.getMembersList().size() + bookstore.getPremiumMembersList().size() + 1) { // invalid selection
            System.out.println("Invalid Selection");
            checkout(bookstore, scnr, purchases);// recursive call if valid user input 

        } else { // valid selection
            if (memberSelect == bookstore.getMembersList().size() + bookstore.getPremiumMembersList().size() + 1) {  // adding a new member
                boolean isPremium = registerNewMember(bookstore, scnr, purchases.size());
                if (isPremium) {
                    System.out.println("Premium membership costs $5, this will be added to your total.");
                    total += 5;
                }
            } else { // existing member
                //determine if customer is regular or premium membr
                if (memberSelect <= bookstore.getMembersList().size()) //regular member
                {
                    customer = bookstore.getMembersList().get(memberSelect - 1);
                    // increment number of purchases for this member
                    customer.incrementPurchases(purchases.size());

                } else {//premium member

                    PremiumMember premiumCustomer = bookstore.getPremiumMembersList().get(memberSelect - bookstore.getMembersList().size() - 1);
                    // increment number of purchases for this member
                    premiumCustomer.incrementPurchases(purchases.size());
                    // check if premium member and fees are due
                    if (!premiumCustomer.hasPaidDues()) {
                        System.out.println("Premium Membership dues unpaid, $5 will be added to purchase total to cover dues.");
                        total += 5;
                        premiumCustomer.setHasPaidDues(true);
                    }

                }
            }

            // done
            System.out.println("Your purchase total was: " + total);
            System.out.println("Thank you for your purchase!");

        }
    }

    /**
     * Method to add a new member
     *
     * @param bookstore
     * @param scnr
     * @return returns 1 for free tier, -1 for premium and 0 for invalid
     * selection
     */
    private static boolean registerNewMember(Bookstore bookstore, Scanner scnr, int numOfItems) {

        System.out.println("Let's get you registered as a new Member!");
        System.out.println("Would you like to register as a free-tier or premium member?");
        System.out.println("\t1. Free-tier");
        System.out.println("\t2. Premium");

        int choice1 = scnr.nextInt();
        if (choice1 > 2 || choice1 < 1) {
            System.out.println("Invalid choice.");
            return registerNewMember(bookstore, scnr, numOfItems); // retry
        } else {
            System.out.println("Please enter your name:");
            scnr.nextLine();
            String name = scnr.nextLine();
            if (choice1 == 1) {
                bookstore.addNewMember(name, false, numOfItems);
                return false;
            } else { // user entered 2
                bookstore.addNewMember(name, true, numOfItems);
                return true;
            }
        }
    }

    /**
     * method to check member status 
     * @param bookstore
     * @param scnr
     */
    private static void checkMemberStatus(Bookstore bookstore, Scanner scnr) {

        System.out.println("Please select your member ID");
        int num = 1;
        for (Member member : bookstore.getMembersList()) {
            System.out.println("\t" + num + ". " + member.getName());
            num++;
        }
        for (PremiumMember member : bookstore.getPremiumMembersList()) {
            System.out.println("\t" + num + ". " + member.getName());
            num++;
        }
        int choice = scnr.nextInt();
        if (choice < 1 || choice > bookstore.getMembersList().size() + bookstore.getPremiumMembersList().size()) {
            //invalid choice
            System.out.println("Invalid choice.");
            return;
        }
        //valid choice - print member details
        bookstore.displayMemberStatus(choice);
    }

    private static double getTotalPurchase(ArrayList<String> purchases) {
        //for each item in cart get price 
        double total = 0;
        for (String cartItem : purchases) {
            //split string to get price value
            total = total + Double.parseDouble(cartItem.split(" - ")[1]);
        }
        return total;
    }

    private static void compareProducts(Bookstore bookstore, Scanner scnr) {
    System.out.println("Enter the ID of the first product:");
    int id1 = scnr.nextInt() - 1; 
    System.out.println("Enter the ID of the second product:");
    int id2 = scnr.nextInt() - 1; 

    Product product1 = bookstore.getProductById(id1);
    Product product2 = bookstore.getProductById(id2);

    if (product1 == null || product2 == null) {
        System.out.println("One or both product IDs are invalid.");
        return;
    }

    int comparison = product1.compareTo(product2);
    if (comparison < 0) {
        System.out.println("Product " + (id1 + 1) + " is less than product " + (id2 + 1));
    } else if (comparison > 0) {
        System.out.println("Product " + (id1 + 1) + " is greater than product " + (id2 + 1));
    } else {
        System.out.println("Product " + (id1 + 1) + " is equal to product " + (id2 + 1));
    }
}


private static void restockProduct(Bookstore bookstore, Scanner scnr) {
    System.out.println("Enter the ID of the product to restock:");
    int id = scnr.nextInt();
    System.out.println("Enter the quantity to add:");
    int quantity = scnr.nextInt();

    bookstore.restockProduct(id, quantity);
    System.out.println("Product " + id + " has been restocked with " + quantity + " units.");
}


}
