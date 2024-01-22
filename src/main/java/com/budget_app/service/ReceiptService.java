package com.budget_app.service;

import com.budget_app.dto.ReceiptDto;
import com.budget_app.entity.Receipt;

import java.util.List;
import java.util.Optional;

public interface ReceiptService {

    ReceiptDto saveReceipt(ReceiptDto receiptDto);

    Optional<ReceiptDto> getReceiptById(Long receiptId);

    List<ReceiptDto> getAllReceipts();

    Optional<ReceiptDto> updateReceiptById(Long receiptId, ReceiptDto receiptDto);

    Optional<ReceiptDto> deleteReceiptById(Long receiptId);
}
