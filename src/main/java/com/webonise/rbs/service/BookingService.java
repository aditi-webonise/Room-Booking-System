package com.webonise.rbs.service;

import com.webonise.rbs.entity.Booking;
import java.util.List;

public interface BookingService {

    List<Booking> getAllBookings() throws Exception;
    Booking bookRoom(Booking booking) throws Exception;
    Booking findByBookingId(Long bookingId) throws Exception;
    Booking editBooking(Booking booking) throws Exception;
    Boolean deleteByBookingId(Long bookingId) throws Exception;
    Boolean checkBookingAvailability(Booking booking) throws Exception;
}
