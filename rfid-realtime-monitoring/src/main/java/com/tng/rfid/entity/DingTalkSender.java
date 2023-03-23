package com.tng.rfid.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;
import java.util.Set;

@Data
@Entity(name = "dingtalk_sender")
public class DingTalkSender extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long laneConfigId;

    private Long monitoringScheduleId;

    @Column
    private Long escalationPlanId;

    @Column(nullable = false)
    private Instant transactionTimeStamp;

    @ManyToMany
    @JoinTable(
            name = "dingtalk_sender_dingtalk_contact",
            joinColumns = @JoinColumn(name = "dingtalk_sender_id"),
            inverseJoinColumns = @JoinColumn(name = "dingtalk_contact_id"))
    Set<DingTalkContact> dingTalkContacts;

    @Column(nullable = false, length = 1000)
    private String message;

    @Column(nullable = false, length = 20)
    private String status;

    @Column(nullable = false)
    private Instant sendTimeStamp;

}
