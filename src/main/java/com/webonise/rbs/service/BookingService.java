package com.webonise.rbs.service;

import com.webonise.rbs.entity.Booking;
import java.util.List;

public interface BookingService {

    List<Booking> getAllBookings();
    Booking bookRoom(Booking booking);
    Booking findByBookingId(Long bookingId);
    Booking editBooking(Booking booking);
    Boolean deleteByBookingId(Long bookingId);
    Boolean checkBookingAvailability(Booking booking);
}
