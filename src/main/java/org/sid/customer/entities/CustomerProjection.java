package org.sid.customer.entities;

import lombok.Data;
import org.springframework.data.rest.core.config.Projection;

@Projection(name ="fullCustomer",types = Customer.class)
public interface CustomerProjection {
    public Long getId();
    public String getName();
}
