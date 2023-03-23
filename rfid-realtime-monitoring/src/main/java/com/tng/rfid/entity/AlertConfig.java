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

    @Column
    private Integer threshold; // Threshold will be in minute

    @Column
    private String alertMessage;

    @ManyToMany
    @JoinTable(
            name = "alert_config_dingtalk_contact",
            joinColumns = @JoinColumn(name = "alert_config_id"),
            inverseJoinColumns = @JoinColumn(name = "dingtalk_contact_id"))
    Set<DingTalkContact> dingTalkContacts;

    @ManyToMany
    @JoinTable(
            name = "alert_config_dingtalk_group",
            joinColumns = @JoinColumn(name = "alert_config_id"),
            inverseJoinColumns = @JoinColumn(name = "dingtalk_group_id"))
    Set<DingTalkGroup> dingTalkGroups;

    @ManyToOne
    @JoinColumn(name = "route_config_id")
    private RouteConfig routeConfig;
}
