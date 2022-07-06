package com.example.iso8583.service;

import com.example.iso8583.entity.Customer;
import com.example.iso8583.model.InquiryCardDto;
import com.example.iso8583.model.InquiryDto;

import java.util.List;


public interface CustomerSerivce {

    List<Customer> getAll();
    InquiryDto getNumberNo(String accNo);
    InquiryCardDto getCardNo(String accNo);
    }
