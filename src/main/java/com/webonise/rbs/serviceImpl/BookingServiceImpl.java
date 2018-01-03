package com.webonise.rbs.serviceImpl;

import com.webonise.rbs.entity.Booking;
import com.webonise.rbs.repository.BookingRepository;
import com.webonise.rbs.service.BookingService;
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
    public List<Booking> getAllBookings() throws Exception {
        try {
            return bookingRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Error in fetching all bookings.");
            throw ex;
        }
    }

    @Override
    public Booking bookRoom(Booking booking) throws Exception {
        try {
            return bookingRepository.save(booking);
        } catch (Exception ex) {
            System.out.println("Error in saving the booking.");
            throw ex;
        }
    }

    @Override
    public Booking findByBookingId(Long bookingId) throws Exception {
        try {
            return bookingRepository.findOne(bookingId);
        } catch (Exception ex) {
            System.out.println("Error in finding the booking.");
            throw ex;
        }
    }

    @Override
    public Booking editBooking(Booking booking) throws Exception {
        try {
            return bookingRepository.save(booking);
        } catch (Exception ex) {
            System.out.println("Error in editing the booking.");
            throw ex;
        }
    }

    @Override
    public Boolean deleteByBookingId(Long bookingId) throws Exception {
        try {
            Booking booking = bookingRepository.findOne(bookingId);
            if (booking != null) {
                bookingRepository.delete(booking);
                return true;
            }
            return false;
        } catch (Exception ex) {
            System.out.println("Error in deleting the booking.");
            throw ex;
        }
    }

    @Override
    public Boolean checkBookingAvailability(Booking booking) throws Exception {
        try {
            Long roomId = booking.room.getId();
            Timestamp startTime = booking.getBookedFrom();
            Timestamp endTime = booking.getBookedTo();
            List<Booking> checkValidStartTime = bookingRepository.findBookingsByRoomIdAndBookedFromIsBetween(roomId, startTime, endTime);
            List<Booking> checkValidEndTime = bookingRepository.findBookingsByRoomIdAndBookedToIsBetween(roomId, startTime, endTime);
            return checkValidStartTime.isEmpty() && checkValidEndTime.isEmpty();
        } catch (Exception ex) {
            System.out.println("Error in checking booking availability.");
            throw ex;
        }
    }
}
