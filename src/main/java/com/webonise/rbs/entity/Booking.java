package com.webonise.rbs.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="bookings")
public class Booking implements Serializable {

    private static final long serialVersionUID = -843414259970947020L;

    @Id
    private Long id;

    @Column(name="room_id")
    private Long roomId;

    @Column(name="user_id")
    private Long userId;

    @Column(name="event_id")
    private Long eventId;

    @Column(name="booked_from")
    private Timestamp bookedFrom;

    @Column(name="booked_to")
    private Timestamp bookedTo;

    @Column(name="status")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Timestamp getBookedFrom() {
        return bookedFrom;
    }

    public void setBookedFrom(Timestamp bookedFrom) {
        this.bookedFrom = bookedFrom;
    }

    public Timestamp getBookedTo() {
        return bookedTo;
    }

    public void setBookedTo(Timestamp bookedTo) {
        this.bookedTo = bookedTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}