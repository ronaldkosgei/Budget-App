package com.budget_app.mapper;

import com.budget_app.dto.ReceiptDto;
import com.budget_app.entity.Receipt;
import org.springframework.stereotype.Component;

@Component
public class ReceiptMapper {

    public static Receipt toEntity(ReceiptDto receiptDto){
        Receipt receipt = new Receipt();
        receipt.setReceiptId(receiptDto.getReceiptId());
        receipt.setUserId(receiptDto.getUserId());
        receipt.setPurchaseDate(receiptDto.getPurchaseDate());
        receipt.setVendorName(receiptDto.getVendorName());
        receipt.setAmountPaid(receiptDto.getAmountPaid());
        receipt.setCurrency(receiptDto.getCurrency());
        receipt.setReceiptUrl(receiptDto.getReceiptUrl());
        receipt.setCategoryId(receiptDto.getCategoryId());
        receipt.setComments(receiptDto.getComments());

        return receipt;
    }

    public static ReceiptDto toDto(Receipt receipt){
        ReceiptDto receiptDto = new ReceiptDto();
        receiptDto.setReceiptId(receipt.getReceiptId());
        receiptDto.setUserId(receipt.getUserId());
        receiptDto.setPurchaseDate(receipt.getPurchaseDate());
        receiptDto.setVendorName(receipt.getVendorName());
        receiptDto.setAmountPaid(receipt.getAmountPaid());
        receiptDto.setCurrency(receipt.getCurrency());
        receiptDto.setReceiptUrl(receipt.getReceiptUrl());
        receiptDto.setCategoryId(receipt.getCategoryId());
        receiptDto.setComments(receipt.getComments());

        return receiptDto;
    }

    public static void updateEntity(Receipt receipt, ReceiptDto receiptDto){
        receipt.setUserId(receiptDto.getUserId());
        receipt.setPurchaseDate(receiptDto.getPurchaseDate());
        receipt.setVendorName(receiptDto.getVendorName());
        receipt.setAmountPaid(receiptDto.getAmountPaid());
        receipt.setCurrency(receiptDto.getCurrency());
        receipt.setReceiptUrl(receiptDto.getReceiptUrl());
        receipt.setCategoryId(receiptDto.getCategoryId());
        receipt.setComments(receiptDto.getComments());
    }
}
