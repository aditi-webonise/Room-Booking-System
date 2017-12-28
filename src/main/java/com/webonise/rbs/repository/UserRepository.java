package com.webonise.rbs.repository;

import com.webonise.rbs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User , Long> {
}