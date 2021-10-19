package com.pluralsight.conferencedemo.models;

import com.pluralsight.conferencedemo.repositories.TimeslotJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TimeslotTest {
    @Autowired
    private TimeslotJpaRepository jpaRepository;

    @Test
    public void testJpaBefore() throws Exception {
        List<Timeslot>  timeslots = jpaRepository.findByStartTimeBefore(Time.valueOf("09:00:00"));
        for(Timeslot timeslot: timeslots){
            System.out.println(timeslot);
        }
        assertTrue(timeslots.size() == 0);
    }

    @Test
    public void testJpaAfter() throws Exception {
        List<Timeslot>  timeslots = jpaRepository.findByStartTimeAfter(Time.valueOf("14:00:00"));
        for(Timeslot timeslot: timeslots){
            System.out.println(timeslot);
        }
        assertTrue(timeslots.size() == 3);
    }

    @Test
    public void testJpaBetween() throws Exception {
        List<Timeslot>  timeslots = jpaRepository.findByStartTimeBetween(Time.valueOf("10:00:00"),Time.valueOf("11:00:00"));
        for(Timeslot timeslot: timeslots){
            System.out.println(timeslot);
        }
        assertTrue(timeslots.size() == 2);
    }
}
