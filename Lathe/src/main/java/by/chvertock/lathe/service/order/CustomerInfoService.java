/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.order;


import by.chvertock.lathe.dao.order.CustomerInfoDao;
import by.chvertock.lathe.model.entities.order.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CustomerInfoService {

    @Autowired
    private CustomerInfoDao customerInfoDao;

    @Transactional
    public void addInfo(CustomerInfo info) {
        customerInfoDao.addInfo(info);
    }

    @Transactional
    public void updateInfo(CustomerInfo info) {
        customerInfoDao.updateInfo(info);
    }

    @Transactional
    public List<CustomerInfo> getInfos() {
        return customerInfoDao.getInfos();
    }

    @Transactional
    public void removeInfo(CustomerInfo info) {
        customerInfoDao.removeInfo(info);
    }

}
