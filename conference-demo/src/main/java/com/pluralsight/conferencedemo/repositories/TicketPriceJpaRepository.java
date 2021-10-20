package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

//Note we can add @NamedQuery, @NamedNativeQuery, @Query and Query DSL in JpaRepository
//Methods with @Query takes highest precedence,
//followed by methods that match a named or native named query
//followed by methods that follow the query DSL keyword naming structure
public interface TicketPriceJpaRepository extends JpaRepository<TicketPrice,Long> {
    //Do this when it is not default DSL, write a JPQL
    @Query("select tp from TicketPrice tp where tp.basePrice < ?1 " +
            "and tp.ticketType.includesWorkshop = true")
    List<TicketPrice> getTicketsUnderPriceWithWorkshops(BigDecimal maxPrice);

    //namedQueries - look at TicketPrice.java
    List<TicketPrice> namedFindTicketsByPricingCategoryName(@Param("name") String name);

    //namedNativeQuery
    List<TicketPrice> nativeFindTicketsByCategoryWithWorkshop(@Param("name") String name);
}
