package com.altimetrik.onilneBusBooking.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.altimetrik.onilneBusBooking.model.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus,Integer> {

	/*List<Bus> findBy(Bus bus);
	@Query(value="SELECT b FROM Bus b WHERE b.sourceCity = :sourceCity and b.destinationCity = :destinationCity and DATE(b.departureTime) = :departureTime", nativeQuery=true)
	List<Bus> findAllBySourceCityAndDestinationCityAndDepartureTime(@Param("sourceCity") String sourceCity, @Param("destinationCity") String destinationCity, @Param("departureTime") LocalDate departureTime);
*/
}