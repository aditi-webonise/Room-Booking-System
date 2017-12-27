package com.webonise.rbs.controller;

import com.webonise.rbs.entity.Room;
import com.webonise.rbs.service.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    RoomServiceImpl roomService;

    @GetMapping(value = "/",produces = MediaType.TEXT_HTML_VALUE)
    public String savePage(Model model) {
        model.addAttribute("room", new Room());
        model.addAttribute("allRooms", roomService.getAllRooms());
        return "viewRooms";
    }

    @PostMapping("/save")
    public String saveRoom(@ModelAttribute("room") Room room, final RedirectAttributes redirectAttributes) {
        if(roomService.addRoom(room)!=null) {
            redirectAttributes.addFlashAttribute("saveRoom", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveRoom", "failure");
        }
        return "redirect:/room/";
    }

    @RequestMapping(value = "/{operation}/{id}", method = RequestMethod.GET)
    public String editRemoveRoom(@PathVariable("operation") String operation, @PathVariable("id") Long id, final RedirectAttributes redirectAttributes, Model model) {
        if(operation.equals("delete")) {
            if(roomService.deleteById(id)) {
                redirectAttributes.addFlashAttribute("deletion", "success");
            } else {
                redirectAttributes.addFlashAttribute("deletion", "failure");
            }
        } else if(operation.equals("edit")){
            Room editRoom = roomService.findById(id);
            if(editRoom!=null) {
                model.addAttribute("editRoom", editRoom);
                return "editRoom";
            } else {
                redirectAttributes.addFlashAttribute("status","notfound");
            }
        }
        return "redirect:/room/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateRoom(@ModelAttribute("editRoom") Room editRoom, final RedirectAttributes redirectAttributes) {
        if(roomService.editRoom(editRoom)!=null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "failure");
        }
        return "redirect:/room/";
    }
} 