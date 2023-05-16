package lt.viko.eif.ih.bakery.server.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/** This is like a branch of Bakery class, the customer consists of id, first name, last name, phone number, and products that customer has in cart.
 * This class has id, name, address variables and cartList so that customer can possess products in a list. For each of the variables there is getter and setter initialised.
 * Also, constructor is created for customer without id so that this value can be assigned automatically for the database.
 * There is a method addToCart that is used to add new product to the cartList.
 * In this class toString() method is overriden for more comfortable viewing.
 */

@Entity
public class Customer {
    private @Id @GeneratedValue Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    @OneToMany(targetEntity = Cart.class, cascade = CascadeType.ALL)
    private List<Cart> cartList = new ArrayList<>();

    public Customer() {

    }

    public Customer(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    public void addToCart(Cart cart) {cartList.add(cart);}

}
