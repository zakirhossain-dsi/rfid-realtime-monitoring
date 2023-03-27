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

    @Column
    private String alertMessage;

    @ManyToMany
    @JoinTable(
            name = "suspicious_txn_contact_config",
            joinColumns = @JoinColumn(name = "suspicious_txn_config_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_config_id"))
    Set<ContactConfig> contactConfigs;
}
