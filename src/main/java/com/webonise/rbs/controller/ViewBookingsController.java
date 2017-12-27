package com.webonise.rbs.controller;

import com.webonise.rbs.entity.Booking;
import com.webonise.rbs.service.ViewBookingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookings")
public class ViewBookingsController {

    @Autowired
    ViewBookingsServiceImpl viewBookingService;

    @GetMapping(value = "/",produces = MediaType.TEXT_HTML_VALUE)
    public String showBookings(Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("allBookings", viewBookingService.getAllBookings());
        return "allBookings";
    }
}
