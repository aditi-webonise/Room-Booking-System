package com.webonise.rbs.serviceImpl;

import com.webonise.rbs.entity.Room;
import com.webonise.rbs.repository.RoomRepository;
import com.webonise.rbs.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getAllRooms() throws Exception {
        try {
            return  roomRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Error in listing all rooms.");
            throw ex;
        }
    }

    @Override
    public Room findByRoomId(Long roomId) throws Exception {
        try {
            return roomRepository.findOne(roomId);
        } catch (Exception ex) {
            System.out.println("Error in finding room.");
            throw ex;
        }
    }

    @Override
    public Room addRoom(Room room) throws Exception {
        try {
            return roomRepository.save(room);
        } catch (Exception ex) {
            System.out.println("Error in adding the room");
            throw ex;
        }
    }

    @Override
    public Room editRoom(Room room) throws Exception {
        try {
            return roomRepository.save(room);
        } catch (Exception ex) {
            System.out.println("Error in editing the room.");
            throw ex;
        }
    }

    @Override
    public Boolean deleteByRoomId(Long roomId) throws Exception {
        try {
            Room room = roomRepository.findOne(roomId);
            if (room != null) {
                roomRepository.delete(room);
                return true;
            }
            return false;
        } catch (Exception ex) {
            System.out.println("Error in deleting the room.");
            throw ex;
        }
    }
}
