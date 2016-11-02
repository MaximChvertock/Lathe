/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.entities.order;

import by.chvertock.lathe.model.entities.Model;
import by.chvertock.lathe.model.entities.tire.Tire;

import javax.persistence.*;

@Entity
@Table(name = "customer_order_tire")
public class CustomerOrderTire extends Model {

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "tire_id")
    private Tire tire;

    @Column(name = "quantity")
    private Integer quantity;

    public CustomerOrderTire() {
    }

    public CustomerOrderTire(Tire tire, Integer quantity) {
        this.tire = tire;
        this.quantity = quantity;
    }

    public Tire getTire() {
        return tire;
    }

    public void setTire(Tire tire) {
        this.tire = tire;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CustomerOrderTire cartTire = (CustomerOrderTire) o;

        return tire != null ? tire.equals(cartTire.tire) : cartTire.tire == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (tire != null ? tire.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerOrderTire{" +
                "id=" + getId() +
                ", tire=" + tire +
                ", quantity=" + quantity +
                '}';
    }
}
