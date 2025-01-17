package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketTypeJpaRepository extends JpaRepository<TicketType,String> {
    //no need to pass in parameter as it just checks if the column is true
    List<TicketType> findByIncludesWorkshopTrue();

}
