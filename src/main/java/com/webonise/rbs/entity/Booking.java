package com.webonise.rbs.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="bookings")
public class Booking implements Serializable {

    private static final long serialVersionUID = -6864008650195849371L;

    @Id
    private Long id;

    @Column(name="room_id")
    private Long roomId;

    @Column(name="user_id")
    private Long userId;

    @Column(name="event_id")
    private Long eventId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="booked_from")
    private Date bookedFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="booked_to")
    private Date bookedTo;

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

    public Date getBookedFrom() {
        return bookedFrom;
    }

    public void setBookedFrom(Date bookedFrom) {
        this.bookedFrom = bookedFrom;
    }

    public Date getBookedTo() {
        return bookedTo;
    }

    public void setBookedTo(Date bookedTo) {
        this.bookedTo = bookedTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
