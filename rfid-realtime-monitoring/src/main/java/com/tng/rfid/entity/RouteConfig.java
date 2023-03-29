package com.tng.rfid.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name = "route_config")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"spId", "plazaId", "laneId"})})
public class RouteConfig extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String spId;

    @Column(length = 100)
    private String spName;

    @Column(length = 10)
    private String plazaId;

    @Column(length = 100)
    private String plazaName;

    @Column(length = 10)
    private String laneId;

    @Column(length = 20)
    private String laneBound;

    @Column(length = 10, nullable = false)
    private String laneType;

    @Column(nullable = false)
    private Boolean isActiveMonitoring;

    @OneToOne
    @JoinColumn(name = "device_config_id", nullable = false)
    private DeviceConfig deviceConfig;

    @ManyToMany
    @JoinTable(
            name = "route_config_alert_group",
            joinColumns = @JoinColumn(name = "route_config_id"),
            inverseJoinColumns = @JoinColumn(name = "alert_group_id"))
    private Set<AlertGroup> alertGroups;

    @ManyToOne
    @JoinColumn(name = "sp_config_id")
    private SPConfiguration spConfiguration;

}
