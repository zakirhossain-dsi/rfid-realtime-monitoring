package com.tng.rfid.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name = "alert_group")
public class AlertGroup extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany
    @JoinTable(name = "alert_group_alert_config",
            joinColumns = @JoinColumn(name = "alert_group_id"),
            inverseJoinColumns = @JoinColumn(name = "alert_config_id"))
    Set<AlertConfig> alertConfigs;
}
