package com.culig.filip.smarthome.repository;

import com.culig.filip.smarthome.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    @Query(nativeQuery = true, value = "call GET_DEVICE_WITH_MAC(:mac )")
    Device findDeviceWithMAC(@Param("mac") String mac);
}
