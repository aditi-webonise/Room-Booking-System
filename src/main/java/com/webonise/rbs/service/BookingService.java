package com.webonise.rbs.service;

import com.webonise.rbs.entity.Booking;
import java.util.List;

public interface BookingService {

    List<Booking> getAllBookings();
    Booking bookRoom(Booking booking);
    Booking findById(Long id);
    Booking editBooking(Booking booking);
    Boolean deleteById(Long id);
}