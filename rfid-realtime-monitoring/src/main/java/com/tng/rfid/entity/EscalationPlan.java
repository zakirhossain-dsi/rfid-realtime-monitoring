package com.tng.rfid.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name = "escalation_plan")
public class EscalationPlan {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "level")
    private Integer level;

    @Column(name = "threshold")
    private Integer threshold;

    // @ManyToMany(fetch = FetchType.LAZY, mappedBy = "escalationPlans")
    // Set<MonitoringSchedule> monitoringSchedules;

    @ManyToMany
    @JoinTable(
            name = "escalation_plan_dingtalk_contact",
            joinColumns = @JoinColumn(name = "escalation_plan_id"),
            inverseJoinColumns = @JoinColumn(name = "dingtalk_contact_id"))
    Set<DingTalkContact> dingTalkContacts;

    @ManyToOne
    @JoinColumn(name="rfid_event_id", nullable=false)
    private RfidEvent rfidEvent;
}
