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

    @Column(nullable = false)
    private Integer escalationLevel;

    @Column(nullable = false)
    private Integer threshold;

    @OneToOne
    @JoinColumn(name = "alert_message_config_Id", nullable = false)
    private AlertMessageConfig alertMessage;

    @ManyToMany
    @JoinTable(
            name = "alert_config_contact_config",
            joinColumns = @JoinColumn(name = "alert_config_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_config_id"))
    Set<ContactConfig> contactConfigs;

}
