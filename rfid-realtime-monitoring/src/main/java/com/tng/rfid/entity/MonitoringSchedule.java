package com.tng.rfid.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name = "monitoring_schedule")
public class MonitoringSchedule {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day")
    private String day;

    @Column(name = "start_time")
    private Integer startTime;

    @Column(name = "end_time")
    private Integer endTime;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "monitoring_schedule_escalation_plan",
            joinColumns = @JoinColumn(name = "monitoring_schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "escalation_plan_id"))
    private Set<EscalationPlan> escalationPlans;

    // @ManyToMany(mappedBy = "monitoringSchedules")
    // private Set<TransactionRoute> transactionRoutes;
}
