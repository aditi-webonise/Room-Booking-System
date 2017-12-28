package com.webonise.rbs.service;

import com.webonise.rbs.entity.Room;
import java.util.List;

public interface RoomService {

    List<Room> getAllRooms();
    Room findById(Long id);
    Room addRoom(Room room);
    Room editRoom(Room room);
    Boolean deleteById(Long id);
}