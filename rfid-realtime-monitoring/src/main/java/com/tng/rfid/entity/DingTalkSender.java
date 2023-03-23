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

    @Column
    private Long routeConfigId;

    @Column
    private Long alertConfigId;

    @Column
    private Integer escalationLeve;

    @Column(nullable = false)
    private Instant transactionTimeStamp;

    @ManyToMany
    @JoinTable(
            name = "dingtalk_sender_dingtalk_contact",
            joinColumns = @JoinColumn(name = "dingtalk_sender_id"),
            inverseJoinColumns = @JoinColumn(name = "dingtalk_contact_id"))
    Set<DingTalkContact> dingTalkContacts;

    @ManyToMany
    @JoinTable(
            name = "dingtalk_sender_dingtalk_group",
            joinColumns = @JoinColumn(name = "dingtalk_sender_id"),
            inverseJoinColumns = @JoinColumn(name = "dingtalk_group_id"))
    Set<DingTalkGroup> dingTalkGroups;

    @Column(nullable = false, length = 1000)
    private String message;

    @Column(nullable = false, length = 20)
    private String status;

    @Column(nullable = false)
    private Instant sendTimeStamp;

}
