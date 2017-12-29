package com.webonise.rbs.repository;

import com.webonise.rbs.entity.Booking;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository <Booking ,Long> {

    List<Booking> findBookingsByRoomIdAndBookedToIsBetween(Long roomId, Timestamp startTime, Timestamp endTime);
    List<Booking> findBookingsByRoomIdAndBookedFromIsBetween(Long roomId, Timestamp startTime, Timestamp endTime);
}
