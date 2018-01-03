package com.webonise.rbs.serviceImpl;

import com.webonise.rbs.entity.Role;
import com.webonise.rbs.repository.RoleRepository;
import com.webonise.rbs.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() throws Exception {
        try {
            return roleRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Error in fetching all roles.");
            throw ex;
        }
    }
}