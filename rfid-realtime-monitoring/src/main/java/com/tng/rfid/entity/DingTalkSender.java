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
    private Integer escalationLevel;

    @Column(nullable = false)
    private Instant transactionTimeStamp;

    private String alertMessage;

    @Column(nullable = false, length = 20)
    private String status;

    @Column(nullable = false)
    private Instant sendTimeStamp;

    @ManyToMany
    @JoinTable(
            name = "dingtalk_sender_contact_config",
            joinColumns = @JoinColumn(name = "dingtalk_sender_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_config_id"))
    Set<ContactConfig> contactConfigs;
}
