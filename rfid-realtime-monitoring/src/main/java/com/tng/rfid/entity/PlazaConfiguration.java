package com.tng.rfid.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity(name = "plaza_config")
public class PlazaConfiguration {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sp_id", length = 2)
    private String spId;

    @Column(name = "plaza_id", length = 3)
    private String plazaId;

    @ManyToMany
    @JoinTable(
            name = "plaza_lane",
            joinColumns = @JoinColumn(name = "plaza_config_id"),
            inverseJoinColumns = @JoinColumn(name = "lane_id"))
    private Set<LaneConfiguration> laneConfigs;

    @ManyToMany
    @JoinTable(
            name = "plaza_monitoring_schedule",
            joinColumns = @JoinColumn(name = "plaza_config_id"),
            inverseJoinColumns = @JoinColumn(name = "monitoring_schedule_id"))
    private Set<MonitoringSchedule> monitoringSchedules;

}
