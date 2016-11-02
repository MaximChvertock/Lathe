/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.beans.order;


import by.chvertock.lathe.model.entities.order.CustomerOrderStatus;

public class CustomerOrderFilter {

    private CustomerOrderStatus status;


    public CustomerOrderStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerOrderStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerOrderFilter that = (CustomerOrderFilter) o;

        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        return status != null ? status.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CustomerOrderFilter{" +
                "status=" + status +
                '}';
    }
}
