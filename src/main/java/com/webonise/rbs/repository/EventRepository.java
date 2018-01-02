package com.webonise.rbs.repository;

import com.webonise.rbs.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository <Event,Long> {
} 