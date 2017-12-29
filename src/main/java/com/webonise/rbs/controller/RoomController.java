package com.webonise.rbs.controller;

import com.webonise.rbs.entity.Room;
import com.webonise.rbs.service.RoomService;
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
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public String savePage(Model model) {
        model.addAttribute("room", new Room());
        model.addAttribute("allRooms", roomService.getAllRooms());
        return "rooms";
    }

    @PostMapping
    public String saveRoom(@ModelAttribute("room") Room room, final RedirectAttributes redirectAttributes) {
        if(roomService.addRoom(room)!= null) {
            redirectAttributes.addFlashAttribute("saveRoom", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveRoom", "failure");
        }
        return "redirect:/room";
    }

    @GetMapping(value = "/{id}")
    public String displayRoom(@PathVariable("id") Long id, final RedirectAttributes redirectAttributes, Model model) {
        Room room = roomService.findByRoomId(id);
        if(room!=null) {
            model.addAttribute("editRoom", room);
            return "editRoom";
        }
        return "redirect:/room";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteRoom( @PathVariable("id") Long id, final RedirectAttributes redirectAttributes, Model model) {
        if(roomService.deleteByRoomId(id)) {
            redirectAttributes.addFlashAttribute("deletion", "success");
        } else {
            redirectAttributes.addFlashAttribute("deletion", "failure");
        }
        return "redirect:/room";
    }

    @PutMapping
    public String updateRoom(@ModelAttribute("editRoom") Room editRoom, final RedirectAttributes redirectAttributes) {
        if(roomService.editRoom(editRoom)!=null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "failure");
        }
        return "redirect:/room";
    }
}
