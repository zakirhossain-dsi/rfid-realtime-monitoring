package com.tng.rfid.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name = "dingtalk_group")
public class DingTalkGroup extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "dingtalk_group_dingtalk_contact",
            joinColumns = @JoinColumn(name = "dingtalk_group_id"),
            inverseJoinColumns = @JoinColumn(name = "dingtalk_contact_id"))
    Set<DingTalkContact> contacts;
}