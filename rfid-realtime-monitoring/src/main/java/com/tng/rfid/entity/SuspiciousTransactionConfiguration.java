package com.tng.rfid.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name = "suspicious_txn_config")
public class SuspiciousTransactionConfiguration {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "suspicious_txn_dingtalk_contact",
            joinColumns = @JoinColumn(name = "suspicious_txn_config_id"),
            inverseJoinColumns = @JoinColumn(name = "dingtalk_contact_id"))
    Set<DingTalkContact> dingTalkContacts;

    @ManyToOne
    @JoinColumn(name="rfid_event_id", nullable=false)
    private RfidEvent rfidEvent;

}
