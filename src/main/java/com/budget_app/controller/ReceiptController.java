package com.budget_app.controller;

import com.budget_app.dto.ReceiptDto;
import com.budget_app.entity.Receipt;
import com.budget_app.service.ReceiptService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @PostMapping("/create")
    public ReceiptDto createReceipt(@RequestBody ReceiptDto receiptDto) {
        return receiptService.saveReceipt(receiptDto);
    }

    @GetMapping("/get/{receiptId}")
    public Optional<ReceiptDto> getReceiptById(@PathVariable Long receiptId) {
        return receiptService.getReceiptById(receiptId);
    }

    @GetMapping("/get/all")
    public Iterable<ReceiptDto> getAllReceipts() {
        return receiptService.getAllReceipts();
    }

    @PutMapping("/update/{receiptId}")
    public Optional<ReceiptDto> updateReceiptById(@PathVariable Long receiptId, @RequestBody ReceiptDto receiptDto) {
        return receiptService.updateReceiptById(receiptId, receiptDto);
    }

    @DeleteMapping("/delete/{receiptId}")
    public void deleteReceiptById(@PathVariable Long receiptId) {
        receiptService.deleteReceiptById(receiptId);
    }

}
