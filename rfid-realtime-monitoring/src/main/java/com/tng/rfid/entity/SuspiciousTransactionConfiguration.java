package com.tng.rfid.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name = "suspicious_txn_config")
public class SuspiciousTransactionConfiguration extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "suspicious_txn_dingtalk_contact",
            joinColumns = @JoinColumn(name = "suspicious_txn_config_id"),
            inverseJoinColumns = @JoinColumn(name = "dingtalk_contact_id"))
    Set<DingTalkContact> dingTalkContacts;

    @ManyToMany
    @JoinTable(
            name = "suspicious_txn_dingtalk_group",
            joinColumns = @JoinColumn(name = "suspicious_txn_config_id"),
            inverseJoinColumns = @JoinColumn(name = "dingtalk_group_id"))
    Set<DingTalkContact> dingTalkGroups;

    private String message;

}
