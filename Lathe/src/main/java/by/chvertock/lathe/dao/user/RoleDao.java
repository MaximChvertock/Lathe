/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.user;



import by.chvertock.lathe.model.entities.user.Role;
import by.chvertock.lathe.model.entities.user.RoleType;

import java.util.List;


public interface RoleDao {
    void addRole(Role role);
    void removeRole(Role role);
    Role getRole(long id);
    List<Role> getRoles();

    Role getRoleByName(RoleType role);
}
