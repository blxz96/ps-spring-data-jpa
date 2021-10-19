package com.pluralsight.conferencedemo.models;

import com.pluralsight.conferencedemo.repositories.SpeakerJpaRepository;
import com.pluralsight.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SpeakerTest {
    @Autowired
    private SpeakerJpaRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testFind() throws Exception {
        Speaker speaker = repository.getOne(1L);
        assertNotNull(speaker);
    }

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
        Speaker s = new Speaker();
        s.setCompany("Pluralsight");
        s.setFirstName("Dan");
        s.setLastName("Bunker");
        s.setTitle("Author");
        s.setSpeakerBio("Consulting and mentoring");
        s = repository.saveAndFlush(s);

        // clear the persistence context so we don't return the previously cached location object
        // this is a test only thing and normally doesn't need to be done in prod code
        entityManager.clear();

        Speaker otherSpeaker = repository.getOne(s.getSpeakerId());
        assertEquals("Dan", otherSpeaker.getFirstName());

        repository.deleteById(otherSpeaker.getSpeakerId());
    }

    @Test
    public void testJpaAnd() throws Exception{
        final List<Speaker> speakers = repository.findByFirstNameAndLastName("James", "Lowrey");
        assertTrue(speakers.size()>0);
    }

    @Test
    public void testJpaOr() throws Exception{
        final List<Speaker> speakers = repository.findByFirstNameOrLastName("James", "Lowrey");
        assertTrue(speakers.size()>0);
    }

    @Test
    public void testJpaNull() throws Exception{
        final List<Speaker> speakers = repository.findBySpeakerPhotoNull();
        assertTrue(speakers.size()>0);
    }

    @Test
    public void testJpaIn() throws Exception{
        List<String> companies = new ArrayList<>();
        companies.add("National Bank");
        companies.add("Contoso");
        final List<Speaker> speakers = repository.findByCompanyIn(companies);
        assertTrue(speakers.size()>0);
    }

    @Test
    public void testJpaIgnoreCase() throws Exception{
        List<Speaker> speakers = repository.findByCompanyIgnoreCase("national bank");
        assertTrue(speakers.size()>0);
    }

    @Test
    public void testJpaOrderByAsc() throws Exception{
        List<Speaker> speakers = repository.findByLastNameOrderByFirstNameAsc("Clark");
        assertTrue(speakers.size()>0);
    }

    @Test
    public void testJpaOrderByDesc() throws Exception{
        List<Speaker> speakers = repository.findByLastNameOrderByFirstNameDesc("Clark");
        assertTrue(speakers.size()>0);
    }

    @Test
    public void testJpaFirst() throws Exception{
        Speaker speaker = repository.findFirstByFirstName("James");
        assertTrue(speaker.getFirstName().equals("James"));
    }

    @Test
    public void testJpaTop4() throws Exception{
        List<Speaker> speakers = repository.findTop4ByFirstName("James");
        for(Speaker s: speakers){
            System.out.println(s.getLastName());
        }
        assertTrue(speakers.size()==4);
    }

    @Test
    public void testJpaDistinct() throws Exception{
        List<Speaker> speakers = repository.findDistinctByFirstName("James");
        for(Speaker s: speakers){
            System.out.println(s.getLastName());
        }
        assertTrue(speakers.size()==4);
    }



}
