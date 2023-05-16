package lt.viko.eif.ih.bakery.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Bakery {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;

    @OneToMany(targetEntity = Customer.class, cascade = CascadeType.ALL)
    private List<Customer> customers = new ArrayList<>();

    public Bakery() {
    }

    public Bakery(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String toString() {
        StringBuilder customersString = new StringBuilder();

        for (int i = 0; i < customers.size(); i++) {
            customersString.append(customers.get(i).toString());
            if (i != customers.size() - 1) {
                customersString.append("\n");
            }
        }

        return String.format("Bakery:\n\tName = %s;\n\tAddress = %s;\n\tCustomers:\n%s", name, address, customersString);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("customers")
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}

