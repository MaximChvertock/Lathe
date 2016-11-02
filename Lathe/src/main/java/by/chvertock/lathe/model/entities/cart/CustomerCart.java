/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.entities.cart;

import by.chvertock.lathe.model.entities.Model;
import by.chvertock.lathe.model.entities.tire.Tire;
import by.chvertock.lathe.model.entities.user.User;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity()
@Table(name = "customer_cart")
@SQLInsert(
        sql = "INSERT INTO " +
                "customer_cart (customer_id) VALUES(?) " +
                "ON DUPLICATE KEY UPDATE " +
                "id = VALUES(id), " +
                "customer_id = VALUES(customer_id);"
)

// TODO : FIX DELETE. BUG: not removing relative objects from 'customer_cart_tire' and 'tires_in_cart'
//@SQLDelete(
//        sql = ""
//)
public class CustomerCart extends Model {

    @NotNull(message = "Customer is NULL")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tires_to_carts",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_tire_id")
    )
    private Set<CustomerCartTire> tires = new HashSet<CustomerCartTire>();// TODO : concurrency?

    @Transient
    private BigDecimal totalPrice;

    @Transient
    private int productsAmount;


    public synchronized User getCustomer() {
        return customer;
    }

    public synchronized void setCustomer(User customer) {
        this.customer = customer;
    }

    public synchronized Set<CustomerCartTire> getTires() {
        return tires;
    }

    public synchronized void setTires(Set<CustomerCartTire> tires) {
        this.tires = tires;
    }

    public synchronized void addTire(Tire tire) {
        if (tire == null) {
            throw new NullPointerException("Can't add tire to customer cart because tire is null");
        }

        CustomerCartTire cartTire = getItem(tire);
        if (cartTire != null) {

            int quantity = cartTire.getQuantity();
            ++quantity;
            cartTire.setQuantity(quantity);

            return;
        }


        // tire not found in list
//        synchronized (tires) {
        tires.add(new CustomerCartTire(tire, 1)); // add new tire to list
//        }
    }

    public synchronized void removeTire(Tire tire) {
        if (tire == null) {
            throw new NullPointerException("Can't remove tire from customer cart because tire is null");
        }

        CustomerCartTire cartTire = getItem(tire);
        if (cartTire != null) {
            int quantity = cartTire.getQuantity();

            --quantity;

            if (quantity > 0) {
                cartTire.setQuantity(quantity);

                return;
            }

            // quantity less or equal zero
//            synchronized (tires) {
            tires.remove(cartTire);
//            }
        }
    }

    public synchronized void removeAllTires() {
        tires.clear();
    }

    public synchronized CustomerCartTire getItem(long id) {
        Iterator<CustomerCartTire> iterator = tires.iterator();
        while (iterator.hasNext()) {
            CustomerCartTire cartTire = iterator.next();
            if (cartTire.getTire().getId() == id) {
                return cartTire;
            }
        }

        return null;
    }

    public synchronized CustomerCartTire getItem(Tire tire) {
        Iterator<CustomerCartTire> iterator = tires.iterator();
        while (iterator.hasNext()) {
            CustomerCartTire cartTire = iterator.next();
            if (cartTire.getTire().equals(tire)) {
                return cartTire;
            }
        }

        return null;
    }

    public synchronized BigDecimal getTotalPrice() {
        totalPrice = BigDecimal.ZERO;
        for (CustomerCartTire cartTire : tires) {
            BigDecimal price = cartTire.getTire().getPrice().multiply(new BigDecimal(cartTire.getQuantity()));
            totalPrice = totalPrice.add(price);
        }

        return totalPrice;
    }

    public synchronized int getProductsAmount() {
        productsAmount = 0;
        for (CustomerCartTire cartTire : tires) {
            productsAmount += cartTire.getQuantity();
        }

        return productsAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CustomerCart that = (CustomerCart) o;

        if (customer != null ? !customer.equals(that.customer) : that.customer != null) return false;
        return tires != null ? tires.equals(that.tires) : that.tires == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (tires != null ? tires.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerCart{" +
                "id=" + getId() +
                ", customer=" + customer +
                ", tires=" + tires +
                ", totalPrice=" + totalPrice +
                ", productsAmount=" + productsAmount +
                '}';
    }

    public synchronized void removeCartTire(CustomerCartTire cartTire) {
        tires.remove(cartTire);
    }

    public synchronized void addCartTire(CustomerCartTire cartTire) {
        tires.add(cartTire);
    }
}
