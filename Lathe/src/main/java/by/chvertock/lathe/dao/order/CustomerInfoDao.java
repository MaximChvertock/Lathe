/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.order;

import by.chvertock.lathe.model.entities.order.CustomerInfo;

import java.util.List;

public interface CustomerInfoDao {
    void addInfo(CustomerInfo info);
    void updateInfo(CustomerInfo info);

    List<CustomerInfo> getInfos();

    void removeInfo(CustomerInfo info);
}
