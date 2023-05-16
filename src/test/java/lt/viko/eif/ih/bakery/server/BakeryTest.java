package lt.viko.eif.ih.bakery.server;

import lt.viko.eif.ih.bakery.server.model.Bakery;
import lt.viko.eif.ih.bakery.server.model.Cart;
import lt.viko.eif.ih.bakery.server.model.Customer;
import org.junit.Assert;
import org.junit.Test;

/**
 This class tests the toString method of the Bakery class
 */
public class BakeryTest {

    @Test
    public void testToString() {
        Customer customer1 = new Customer("Ihor", "Halytskyi", "+380675321902");
        Bakery bakery1 = new Bakery("Baking Bread", "Studentu 47");
        Cart cart = new Cart("Bread", 25);
        bakery1.addCustomer(customer1);
        customer1.addToCart(cart);

        boolean customerFound = false;
        for (Customer customer : bakery1.getCustomers()) {
            if (customer.getFirstName().equals("Ihor") && customer.getLastName().equals("Halytskyi")) {
                customerFound = true;
                break;
            }
        }

        Assert.assertTrue(customerFound);
    }
}






