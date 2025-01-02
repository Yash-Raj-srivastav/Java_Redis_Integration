package com.redis.integration.java.redisIntegration.Repository;

import com.redis.integration.java.redisIntegration.Entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
