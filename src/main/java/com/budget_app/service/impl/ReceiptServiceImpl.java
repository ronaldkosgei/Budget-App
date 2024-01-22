package com.budget_app.service.impl;

import com.budget_app.dto.ReceiptDto;
import com.budget_app.entity.Receipt;
import com.budget_app.mapper.ReceiptMapper;
import com.budget_app.repository.ReceiptRepository;
import com.budget_app.service.ReceiptService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;

    private final ReceiptMapper receiptMapper;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository, ReceiptMapper receiptMapper) {
        this.receiptRepository = receiptRepository;
        this.receiptMapper = receiptMapper;
    }

    @Override
    public ReceiptDto saveReceipt(ReceiptDto receiptDto) {
        Receipt receipt = receiptMapper.toEntity(receiptDto);
        receipt = receiptRepository.save(receipt);
        return receiptMapper.toDto(receipt);
    }

    @Override
    public Optional<ReceiptDto> getReceiptById(Long receiptId) {
        try {
            Optional<Receipt> receipt = receiptRepository.findById(receiptId);
            if (receipt.isPresent()) {
                return Optional.of(receiptMapper.toDto(receipt.get()));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<ReceiptDto> getAllReceipts() {
        List<Receipt> allReceipts = receiptRepository.findAll();
        return allReceipts.stream()
                .map(ReceiptMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ReceiptDto> updateReceiptById(Long receiptId, ReceiptDto receiptDto) {
        try {
            Optional<Receipt> receiptOptional = receiptRepository.findById(receiptId);
            if (receiptOptional.isPresent()){
                Receipt existingReceipt = receiptOptional.get();
                Receipt updatedReceipt = receiptRepository.save(existingReceipt);
                return Optional.of(receiptMapper.toDto(updatedReceipt));
            }else {
                return Optional.empty();
            }
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<ReceiptDto> deleteReceiptById(Long receiptId) {
        try {
            Optional<Receipt> receiptOptional = receiptRepository.findById(receiptId);
            if (receiptOptional.isPresent()){
                Receipt existingReceipt = receiptOptional.get();
                receiptRepository.delete(existingReceipt);
                return Optional.of(receiptMapper.toDto(existingReceipt));
            }else {
                return Optional.empty();
            }
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
