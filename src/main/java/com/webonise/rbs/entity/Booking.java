package com.webonise.rbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "bookings")
public class Booking implements Serializable {

    private static final long serialVersionUID = -6864008650195849371L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Future(message = "Enter a date in future")
    @Column(name = "booked_from")
    private Timestamp bookedFrom;

    @Future(message = "Enter a date in future")
    @Column(name = "booked_to")
    private Timestamp bookedTo;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "userId")
    public User user;

    @ManyToOne
    @JoinColumn(name = "roomId")
    public Room room;

    @ManyToOne
    @JoinColumn(name = "eventId")
    public Event event;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
