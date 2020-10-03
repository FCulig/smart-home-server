package com.culig.filip.smarthome.repository;

import com.culig.filip.smarthome.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {
    @Query(nativeQuery = true,value = "call GET_TEMPERATURES_BETWEEN(:from, :until )")
    List<Temperature> findAllTemperaturesRecordedBetween(@Param("from") String from,@Param("until") String until);

    @Query(nativeQuery = true,value = "call GET_TEMPERATURES_BEFORE(:until )")
    List<Temperature> findAllTemperaturesRecordedUntil(@Param("until") String until);

    @Query(nativeQuery = true,value = "call GET_TEMPERATURES_AFTER(:from )")
    List<Temperature> findAllTemperaturesRecordedFrom(@Param("from") String from);

    @Query(nativeQuery = true,value = "call GET_ALL_TEMPERATURES()")
    List<Temperature> getAllTemperatures();
}
