package by.chvertock.lathe.model.entities.order;


import by.chvertock.lathe.model.entities.Model;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;

@Entity
@Table(name = "customer_order_status")
@SQLInsert(
        sql = "INSERT INTO " +
                "customer_order_status (status) values(?) " +
                "ON DUPLICATE KEY UPDATE " +
                "id = VALUES(id), " +
                "status = VALUES(status);"
)
public class CustomerOrderStatus extends Model {

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusType status;

    public CustomerOrderStatus() {
        this.status = StatusType.ORDER_IS_NOT_PROCESSED;
    }

    public CustomerOrderStatus(StatusType status) {
        this.status = status;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CustomerOrderStatus that = (CustomerOrderStatus) o;

        return status == that.status;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return status.name();
    }
}
