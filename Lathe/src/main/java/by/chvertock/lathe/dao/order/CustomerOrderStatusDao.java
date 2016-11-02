/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.order;


import by.chvertock.lathe.model.entities.order.CustomerOrderStatus;
import by.chvertock.lathe.model.entities.order.StatusType;

public interface CustomerOrderStatusDao {
   CustomerOrderStatus getStatusByType(StatusType type);
}
