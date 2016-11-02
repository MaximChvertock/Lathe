package by.chvertock.lathe.service.user;


import by.chvertock.lathe.dao.user.RoleDao;
import by.chvertock.lathe.model.entities.user.Role;
import by.chvertock.lathe.model.entities.user.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RoleService {

    @Autowired
    private RoleDao roleDao;

    @Transactional
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Transactional
    public void removeRole(Role role) {
        roleDao.removeRole(role);
    }

    @Transactional
    public Role getRole(long id) {
        return roleDao.getRole(id);
    }

    @Transactional
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

    @Transactional
    public Role getRoleByName(RoleType role){
        return roleDao.getRoleByName(role);
    }
}
