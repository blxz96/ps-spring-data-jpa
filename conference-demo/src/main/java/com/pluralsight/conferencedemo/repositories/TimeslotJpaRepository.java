package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.List;

public interface TimeslotJpaRepository extends JpaRepository<Timeslot, Long> {
    List<Timeslot> findByStartTimeBefore(Time startTime);
    List<Timeslot> findByStartTimeAfter(Time startTime);
    List<Timeslot> findByStartTimeBetween(Time startTime, Time endTime);

}
