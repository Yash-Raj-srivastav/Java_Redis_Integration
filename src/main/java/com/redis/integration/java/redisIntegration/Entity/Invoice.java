package com.redis.integration.java.redisIntegration.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoice implements Serializable {
    private static final long serialVersionUID = -4439114469417994311L;

    @Id
    @GeneratedValue
    private Integer invId;
    private String invName;
    private Double invAmount;

    public String getInvName() {
        return invName;
    }

    public void setInvName(String invName) {
        this.invName = invName;
    }

    public Double getInvAmount() {
        return invAmount;
    }

    public void setInvAmount(Double invAmount) {
        this.invAmount = invAmount;
    }
}
