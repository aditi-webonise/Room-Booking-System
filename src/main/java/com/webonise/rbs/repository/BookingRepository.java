package com.webonise.rbs.repository;

import com.webonise.rbs.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository <Booking ,Long> {
}
