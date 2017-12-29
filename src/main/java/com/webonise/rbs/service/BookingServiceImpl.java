package com.webonise.rbs.service;

import com.webonise.rbs.entity.Booking;
import com.webonise.rbs.repository.BookingRepository;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking bookRoom(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking findByBookingId(Long bookingId) {
        return bookingRepository.findOne(bookingId);
    }

    @Override
    public Booking editBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Boolean deleteByBookingId(Long bookingId) {
        Booking booking = bookingRepository.findOne(bookingId);
        if (booking != null) {
            bookingRepository.delete(booking);
            return true;
        }
        return false;
    }

    @Override
    public Boolean checkBookingAvailability(Booking booking) {
        Long roomId = booking.room.getId();
        Timestamp startTime = booking.getBookedFrom();
        Timestamp endTime = booking.getBookedTo();
        List<Booking> checkListOne = bookingRepository.findBookingsByRoomIdAndBookedFromIsBetween(roomId, startTime, endTime);
        List<Booking> checkListTwo = bookingRepository.findBookingsByRoomIdAndBookedToIsBetween(roomId,startTime,endTime);
        if (checkListOne.isEmpty() && checkListTwo.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
