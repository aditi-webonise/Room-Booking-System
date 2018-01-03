package com.webonise.rbs.controller;

import com.webonise.rbs.constants.RedirectStatus;
import com.webonise.rbs.entity.Booking;
import com.webonise.rbs.service.BookingService;
import com.webonise.rbs.service.EventService;
import com.webonise.rbs.service.RoomService;
import com.webonise.rbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/book")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String showBookings (Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("allBookings", bookingService.getAllBookings());
        model.addAttribute("allRooms", roomService.getAllRooms());
        model.addAttribute("allEvents", eventService.getAllEvents());
        model.addAttribute("allUsers", userService.getAllUsers());
        return "bookings";
    }

    @PostMapping
    public String saveBooking (@ModelAttribute("booking") Booking booking, final RedirectAttributes redirectAttributes) {
        if (bookingService.checkBookingAvailability(booking) && bookingService.bookRoom(booking) != null) {
            redirectAttributes.addFlashAttribute("saveBooking", RedirectStatus.SUCCESS.getStatus());
        } else {
            redirectAttributes.addFlashAttribute("saveBooking", RedirectStatus.FAILURE.getStatus());
        }
        return "redirect:/book";
    }

    @GetMapping(value = "/{id}")
    public String displayBooking (@PathVariable("id") Long id, Model model) {
        model.addAttribute("allRooms", roomService.getAllRooms());
        model.addAttribute("allEvents", eventService.getAllEvents());
        Booking booking = bookingService.findByBookingId(id);
        if(booking != null) {
            model.addAttribute("editBooking", booking);
            return "editBooking";
        }
        return "redirect:/book";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteBooking (@PathVariable("id") Long id, final RedirectAttributes redirectAttributes) {
        if(bookingService.deleteByBookingId(id)) {
            redirectAttributes.addFlashAttribute("deletion", RedirectStatus.SUCCESS.getStatus());
        } else {
            redirectAttributes.addFlashAttribute("deletion", RedirectStatus.FAILURE.getStatus());
        }
        return "redirect:/book";
    }

    @PutMapping
    public String updateBooking (@ModelAttribute("editBooking") Booking booking, final RedirectAttributes redirectAttributes) {
        if (bookingService.checkBookingAvailability(booking) && bookingService.editBooking(booking) != null) {
            redirectAttributes.addFlashAttribute("edit", RedirectStatus.SUCCESS.getStatus());
        } else {
            redirectAttributes.addFlashAttribute("edit", RedirectStatus.FAILURE.getStatus());
        }
        return "redirect:/book";
    }
}
