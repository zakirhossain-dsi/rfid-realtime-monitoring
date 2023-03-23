package com.tng.rfid.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity(name = "sp_configs")
public class SPConfiguration extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String spId;

    @Column
    private Integer transactionAllowableMonitorPeriod;

    @OneToMany(mappedBy = "spConfiguration")
    private Set<RouteConfig> routeConfigs;

}