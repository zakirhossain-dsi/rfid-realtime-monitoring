package com.tng.rfid.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "ignore_device_config")
public class IgnoreRfidDeviceType extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "device_config_id", nullable = false, unique = true)
    private DeviceConfig deviceConfig;

}
