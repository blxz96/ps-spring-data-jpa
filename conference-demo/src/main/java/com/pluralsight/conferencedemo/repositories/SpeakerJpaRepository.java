package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeakerJpaRepository extends JpaRepository<Speaker,Long> {
    List<Speaker> findByFirstNameAndLastName(String firstName, String lastName);
    List<Speaker> findByFirstNameOrLastName(String firstName, String lastName);
    //same as isNull
    List<Speaker> findBySpeakerPhotoNull();
    List<Speaker> findByCompanyIn(List<String> companies);
    List<Speaker> findByCompanyIgnoreCase(String company);
    List<Speaker> findByLastNameOrderByFirstNameAsc(String lastName);
    List<Speaker> findByLastNameOrderByFirstNameDesc(String lastName);
    Speaker findFirstByFirstName(String firstName);
    List<Speaker> findTop4ByFirstName(String firstName);
    List<Speaker> findDistinctByFirstName(String firstName);

}
