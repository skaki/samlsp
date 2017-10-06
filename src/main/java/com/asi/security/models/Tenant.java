package com.asi.security.models;

import javax.persistence.*;

import lombok.Data;

/**
 * Created by skaki on 9/26/17.
 */

@Data
@Entity
@Table(name = "tenant")
public class Tenant {
    private @Id @Column(name = "tenant_id", nullable = false) Long tenant_id;
    private @Column(name = "tenant_name", nullable = true) String tenant_name;
    private @Column(name = "tenant_description", nullable = true) String tenant_description;
    private @Column(name = "client_id", nullable = true) String client_id;
}
