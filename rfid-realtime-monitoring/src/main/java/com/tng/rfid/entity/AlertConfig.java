package com.tng.rfid.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name = "alert_config")
public class AlertConfig extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String day;

    @Column(name = "start_time", nullable = false)
    private Integer startTime;

    @Column(name = "end_time", nullable = false)
    private Integer endTime;

    @ManyToMany
    @JoinTable(name = "alert_config_escalation_config",
            joinColumns = @JoinColumn(name = "alert_config_id"),
            inverseJoinColumns = @JoinColumn(name = "escalation_config_id"))
    private Set<EscalationConfig> escalationConfig;

}
