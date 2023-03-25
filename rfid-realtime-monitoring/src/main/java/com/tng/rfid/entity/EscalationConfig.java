package com.tng.rfid.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name = "escalation_config")
public class EscalationConfig extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String escalationName;

    @Column(nullable = false)
    private Integer escalationLevel;

    @OneToOne
    @JoinColumn(name = "alert_message_config_Id", nullable = false)
    private AlertMessageConfig alertMessage;

    @Column(nullable = false)
    private Integer threshold; // Threshold will be in minute

    @ManyToMany
    @JoinTable(
            name = "escalation_config_contact_config",
            joinColumns = @JoinColumn(name = "escalation_config_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_config_id"))
    Set<ContactConfig> contactConfigs;
}
