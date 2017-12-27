package com.webonise.rbs.service;

import com.webonise.rbs.entity.Booking;
import com.webonise.rbs.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ViewBookingsServiceImpl implements ViewBookingsService {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBookings() {
        return  bookingRepository.findAll();
    }
}
