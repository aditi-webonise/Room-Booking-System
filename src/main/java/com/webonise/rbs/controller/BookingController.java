package com.webonise.rbs.controller;

import com.webonise.rbs.entity.Booking;
import com.webonise.rbs.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/book")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public String showBookings(Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("allBookings", bookingService.getAllBookings());
        return "bookings";
    }

    @PostMapping
    public String saveBooking(@ModelAttribute("booking") Booking booking, final RedirectAttributes redirectAttributes) {
        if(bookingService.bookRoom(booking)!= null) {
            redirectAttributes.addFlashAttribute("saveBooking", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveBooking", "failure");
        }
        return "redirect:/book";
    }
}
