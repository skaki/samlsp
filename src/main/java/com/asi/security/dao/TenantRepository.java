package com.asi.security.dao;

import com.asi.security.models.Tenant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by skaki on 9/26/17.
 */
public interface TenantRepository extends CrudRepository<Tenant, Long> {
        List<Tenant> findAll();
}
