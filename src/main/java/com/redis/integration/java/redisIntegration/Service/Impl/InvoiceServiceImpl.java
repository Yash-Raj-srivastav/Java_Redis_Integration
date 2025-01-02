package com.redis.integration.java.redisIntegration.Service.Impl;

import com.redis.integration.java.redisIntegration.Entity.Invoice;
import com.redis.integration.java.redisIntegration.Exceptions.InvoiceNotFoundException;
import com.redis.integration.java.redisIntegration.Repository.InvoiceRepository;
import com.redis.integration.java.redisIntegration.Service.InvoiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    @Cacheable(value = "Invoice", key = "#invId")
    public Invoice getInvoice(Integer invId) {
        return invoiceRepository.findById(invId).orElseThrow(() -> new InvoiceNotFoundException("Invoice not found for id: " + invId));
    }

    @Override
    @CacheEvict(value = "Invoice", key = "#invId")
    public void deleteInvoice(Integer invId) {
        Invoice invoice = invoiceRepository.findById(invId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice not found for id: " + invId));
        invoiceRepository.delete(invoice);
    }

    @Override
    @Caching(
            evict = {@CacheEvict(value = "Invoices", allEntries = true), @CacheEvict(value = "Invoice", key = "#invId")},
            put   = {@CachePut(value = "Invoice", key = "#invId")}
    )
    public Invoice updateInvoice(Invoice invoice, Integer invId) {
        Invoice inv = invoiceRepository.findById(invId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice not found for id: " + invId));
        inv.setInvName(invoice.getInvName());
        inv.setInvAmount(invoice.getInvAmount());
        return invoiceRepository.save(inv);
    }

    @Override
    @Cacheable(value = "Invoices")
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }
}
