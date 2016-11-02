package by.chvertock.lathe.model.entities.order;

import by.chvertock.lathe.model.entities.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer_order")
public class CustomerOrder extends Model {


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tires_to_orders",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "order_tire_id")
    )
    private Set<CustomerOrderTire> tires = new HashSet<CustomerOrderTire>();

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private CustomerOrderStatus status;

    @NotNull(message = "Identificator is NULL")
    @Column(name = "identificator")
    private String identificator;

    @NotNull(message = "Customer info is NULL")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "customer_info_id")
    private CustomerInfo customerInfo;

    @NotNull(message = "Date is NULL")
    @Column(name = "date")
    private Date date;


    @Transient
    private BigDecimal totalPrice;

    @Transient
    private int productsAmount;

    public Set<CustomerOrderTire> getTires() {
        return tires;
    }

    public void setTires(Set<CustomerOrderTire> tires) {
        this.tires = tires;
    }

    public CustomerOrderStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerOrderStatus status) {
        this.status = status;
    }

    public String getIdentificator() {
        return identificator;
    }

    public void setIdentificator(String identificator) {
        this.identificator = identificator;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public synchronized BigDecimal getTotalPrice() {
        totalPrice = BigDecimal.ZERO;
        for (CustomerOrderTire cartTire : tires) {
            BigDecimal price = cartTire.getTire().getPrice().multiply(new BigDecimal(cartTire.getQuantity()));
            totalPrice = totalPrice.add(price);
        }

        return totalPrice;
    }

    public synchronized int getProductsAmount() {
        productsAmount = 0;
        for (CustomerOrderTire cartTire : tires) {
            productsAmount += cartTire.getQuantity();
        }

        return productsAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CustomerOrder order = (CustomerOrder) o;

        if (tires != null ? !tires.equals(order.tires) : order.tires != null) return false;
        if (status != null ? !status.equals(order.status) : order.status != null) return false;
        if (identificator != null ? !identificator.equals(order.identificator) : order.identificator != null)
            return false;
        if (customerInfo != null ? !customerInfo.equals(order.customerInfo) : order.customerInfo != null) return false;
        return date != null ? date.equals(order.date) : order.date == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (tires != null ? tires.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (identificator != null ? identificator.hashCode() : 0);
        result = 31 * result + (customerInfo != null ? customerInfo.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "id=" + getId() +
                ", tires=" + tires +
                ", status=" + status +
                ", identificator='" + identificator + '\'' +
                ", customerInfo=" + customerInfo +
                ", date=" + date +
                '}';
    }
}
