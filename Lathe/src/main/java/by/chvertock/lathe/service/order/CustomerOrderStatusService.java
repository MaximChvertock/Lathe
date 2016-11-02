/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.order;

import by.chvertock.lathe.dao.order.CustomerOrderStatusDao;
import by.chvertock.lathe.model.entities.order.CustomerOrderStatus;
import by.chvertock.lathe.model.entities.order.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerOrderStatusService {
    @Autowired
    private CustomerOrderStatusDao customerOrderStatusDao;

    @Transactional
    public CustomerOrderStatus getStatusByType(StatusType type) {
        return customerOrderStatusDao.getStatusByType(type);
    }
}
