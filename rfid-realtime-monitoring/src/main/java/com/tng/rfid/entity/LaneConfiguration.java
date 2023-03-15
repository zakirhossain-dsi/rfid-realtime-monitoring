package com.tng.rfid.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name = "lane_configuration")
public class LaneConfiguration {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 3)
    private String laneId;

    @Column(length = 10)
    private String laneType;

    @Column(length = 10)
    private String laneBound;

    @OneToOne
    @JoinColumn(name = "rfid_device_type_id", nullable = false)
    private RfidDeviceType rfidDeviceType;

    /*
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "lane_device_type",
            joinColumns = @JoinColumn(name = "lane_configuration_id"),
            inverseJoinColumns = @JoinColumn(name = "device_type_id"))
    private Set<RfidDeviceType> rfidDeviceTypes;
    */

}
