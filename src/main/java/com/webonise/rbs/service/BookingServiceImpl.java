package com.webonise.rbs.service;

import com.webonise.rbs.entity.Booking;
import com.webonise.rbs.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBookings() {
        return  bookingRepository.findAll();
    }

    @Override
    public Booking bookRoom(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking findById(Long id) {
        return bookingRepository.findOne(id);
    }

    @Override
    public Booking editBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Boolean deleteById(Long id) {
        Booking booking = bookingRepository.findOne(id);
        if (booking != null) {
            bookingRepository.delete(booking);
            return true;
        }
        return false;
    }
}


