package com.webonise.rbs.repository;

import com.webonise.rbs.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Long> {
}
