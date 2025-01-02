package com.redis.integration.java.redisIntegration.Controller;

import com.redis.integration.java.redisIntegration.Entity.Invoice;
import com.redis.integration.java.redisIntegration.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/save-invoice")
    public Invoice saveInvoice(@RequestBody Invoice inv) {
        return invoiceService.saveInvoice(inv);
    }

    @GetMapping("/all-invoice")
    public ResponseEntity<List<Invoice>> getAllInvoices(){
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @GetMapping("/get-one-invoice")
    public Invoice getInvoice(@RequestParam Integer id) {
        return invoiceService.getInvoice(id);
    }

    @PutMapping("/modify-invoice")
    public Invoice updateInvoice(@RequestBody Invoice inv, @RequestParam Integer id) {
        return invoiceService.updateInvoice(inv, id);
    }

    @DeleteMapping("/delete-invoice")
    public String deleteInvoice(@RequestParam Integer id) {
        invoiceService.deleteInvoice(id);
        return "Employee with id: "+id+ " Deleted !";
    }
}
