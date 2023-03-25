package com.tng.rfid.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@DynamicInsert
@DynamicUpdate
@Entity(name = "device_config")
public class DeviceConfig extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String deviceId;

    @Column(unique = true, nullable = false)
    private String deviceName;

    @Column(nullable = false)
    private String deviceType;

    @Column
    private Boolean isActive;
}
