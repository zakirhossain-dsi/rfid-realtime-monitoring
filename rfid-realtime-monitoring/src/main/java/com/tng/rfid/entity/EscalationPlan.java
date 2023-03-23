package com.tng.rfid.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name = "escalation_plan")
public class EscalationPlan extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer level;

    @Column
    private Integer threshold; // Threshold will be in minute

    @ManyToMany
    @JoinTable(
            name = "escalation_plan_dingtalk_contact",
            joinColumns = @JoinColumn(name = "escalation_plan_id"),
            inverseJoinColumns = @JoinColumn(name = "dingtalk_contact_id"))
    Set<DingTalkContact> dingTalkContacts;

    @ManyToMany
    @JoinTable(
            name = "escalation_plan_dingtalk_group",
            joinColumns = @JoinColumn(name = "escalation_plan_id"),
            inverseJoinColumns = @JoinColumn(name = "dingtalk_group_id"))
    Set<DingTalkGroup> dingTalkGroups;

    private String alertMessage;
}
