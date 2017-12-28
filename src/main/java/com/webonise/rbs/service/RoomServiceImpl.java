package com.webonise.rbs.service;

import com.webonise.rbs.entity.Room;
import com.webonise.rbs.repository.RoomRepository;
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
    public List<Room> getAllRooms() {
        return  roomRepository.findAll();
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findOne(id);
    }

    @Override
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room editRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Boolean deleteById(Long id) {
        Room room = roomRepository.findOne(id);
        if(room != null) {
            roomRepository.delete(room);
            return true;
        }
        return false;
    }
} 