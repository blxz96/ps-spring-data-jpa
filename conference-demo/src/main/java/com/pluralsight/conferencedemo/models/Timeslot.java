package com.pluralsight.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name ="time_slots")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Timeslot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="time_slot_id")
    private Long timeSlotId;

    @Column(name="time_slot_date")
    private Date timeSlotDate;

    @Column(name="start_time")
    private Time startTime;

    @Column(name="end_time")
    private Time endTime;

    @Column(name="is_keynote_time_slot")
    private Boolean isKeynoteTimeSlot;

    public Timeslot() {
    }

    public Long getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(Long timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public Date getTimeSlotDate() {
        return timeSlotDate;
    }

    public void setTimeSlotDate(Date timeSlotDate) {
        this.timeSlotDate = timeSlotDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Boolean getKeynoteTimeSlot() {
        return isKeynoteTimeSlot;
    }

    public void setKeynoteTimeSlot(Boolean keynoteTimeSlot) {
        isKeynoteTimeSlot = keynoteTimeSlot;
    }

    @Override
    public String toString() {
        return "Timeslot{" +
                "timeSlotId=" + timeSlotId +
                ", timeSlotDate=" + timeSlotDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", isKeynoteTimeSlot=" + isKeynoteTimeSlot +
                '}';
    }
}
