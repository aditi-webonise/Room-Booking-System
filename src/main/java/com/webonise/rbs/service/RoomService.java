package com.webonise.rbs.service;

import com.webonise.rbs.entity.Room;
import java.util.List;

public interface RoomService {

    List<Room> getAllRooms() throws Exception;
    Room findByRoomId(Long roomId) throws Exception;
    Room addRoom(Room room) throws Exception;
    Room editRoom(Room room) throws Exception;
    Boolean deleteByRoomId(Long roomId) throws Exception;
}
