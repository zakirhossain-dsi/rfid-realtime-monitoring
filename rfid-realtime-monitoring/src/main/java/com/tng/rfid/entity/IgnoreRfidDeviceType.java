package com.tng.rfid.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class IgnoreRfidDeviceType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "rfid_device_type_id", nullable = false, unique = true)
    private RfidDeviceType rfidDeviceType;

}
