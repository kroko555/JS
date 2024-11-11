package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDAO;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDao) {
        this.roleDAO = roleDao;
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleDAO.saveRole(role);
    }

    @Override
    @Transactional(readOnly = true)
    public Role getRole(String role) {
        return roleDAO.getRole(role);
    }

    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    @Transactional
    public Role getRoleById(long id) {
        return roleDAO.getRoleById(id);
    }
}

