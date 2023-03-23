package com.tng.rfid.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "dingtalk_contact")
public class DingTalkContact extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String countryCode;

    @Column(nullable = false)
    private String mobileNumber;
}