package com.webonise.rbs.service;

import com.webonise.rbs.entity.Room;
import java.util.List;

public interface RoomService {

    List<Room> getAllRooms();
    Room findByRoomId(Long roomId);
    Room addRoom(Room room);
    Room editRoom(Room room);
    Boolean deleteByRoomId(Long roomId);
}
