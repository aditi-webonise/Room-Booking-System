package com.webonise.rbs.repository;

import com.webonise.rbs.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository <Room, Long> {
}
