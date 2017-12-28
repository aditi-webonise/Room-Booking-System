package com.webonise.rbs.controller;

import com.webonise.rbs.entity.Booking;
import com.webonise.rbs.service.BookingService;
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

    @GetMapping(value = "/{id}")
    public String editBooking(@PathVariable("id") Long id, final RedirectAttributes redirectAttributes, Model model) {
        Booking editBooking = bookingService.findById(id);
        if(editBooking!=null) {
            model.addAttribute("editBooking", editBooking);
            return "editBooking";
        }
        return "redirect:/book";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteBooking( @PathVariable("id") Long id, final RedirectAttributes redirectAttributes, Model model) {
        if(bookingService.deleteById(id)) {
            redirectAttributes.addFlashAttribute("deletion", "success");
        } else {
            redirectAttributes.addFlashAttribute("deletion", "failure");
        }
        return "redirect:/book";
    }

    @PutMapping
    public String updateBooking(@ModelAttribute("editBooking") Booking editBooking, final RedirectAttributes redirectAttributes) {
        if(bookingService.editBooking(editBooking)!=null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "failure");
        }
        return "redirect:/book";
    }
}
