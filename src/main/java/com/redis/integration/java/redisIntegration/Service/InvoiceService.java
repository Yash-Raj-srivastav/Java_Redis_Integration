package com.redis.integration.java.redisIntegration.Service;

import com.redis.integration.java.redisIntegration.Entity.Invoice;

import java.util.List;

public interface InvoiceService {
    public Invoice saveInvoice(Invoice invoice);
    public Invoice getInvoice(Integer invId);
    public void deleteInvoice(Integer invId);
    public Invoice updateInvoice(Invoice invoice, Integer id);
    public List<Invoice> getAllInvoices();
}
