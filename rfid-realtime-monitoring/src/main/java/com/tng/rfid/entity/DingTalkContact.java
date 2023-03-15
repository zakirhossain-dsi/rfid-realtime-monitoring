package com.tng.rfid.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "dingtalk_contact")
public class DingTalkContact {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;
}
