package com.example.iso8583.service;


import com.example.iso8583.entity.Customer;
import com.example.iso8583.entity.Iso8583;
import com.example.iso8583.entity.Transaction;
import com.example.iso8583.model.InquiryCardDto;
import com.example.iso8583.model.InquiryDto;
import com.example.iso8583.repository.CustomerRepository;
import com.example.iso8583.repository.Iso8583Repository;
import com.example.iso8583.repository.TransactionRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class CustomerServiceImpl implements CustomerSerivce {
    @Autowired
    private CustomerRepository cusRep;

    @Autowired
    private TransactionRepository tranRep;

    @Autowired
    private Iso8583Repository iso8583Rep;

    @Override
    @Transactional
    public List<Customer> getAll() {
        return cusRep.findAll();
    }

    public InquiryDto getNumberNo(String accNo) {
        Customer entity= cusRep.findByInquiry(accNo);
        InquiryDto inquiry = new InquiryDto();
        inquiry.setBenId(entity.getBenId());
        inquiry.setAcctNo(entity.getAcctNo());

        Transaction tx = new Transaction();
        Date date=java.util.Calendar.getInstance().getTime();
        Random rand = new Random();
        Integer number = rand.nextInt(1000000000) + 1;
        Gson gson = new Gson();
        tx.setAcctNo(inquiry.getAcctNo());
        tx.setBenId(inquiry.getBenId());
        tx.setDateTime(date);
        tx.setTrace(number);
        tx.setType("inquiry");
        tranRep.save(tx);

        String jsonInquiry = gson.toJson(inquiry);
        Iso8583 iso = new Iso8583();
        iso.setJson(jsonInquiry);
        iso8583Rep.save(iso);

        String jsonTx = gson.toJson(tx);
        Iso8583 isoTx = new Iso8583();
        isoTx.setJson(jsonTx);
        iso8583Rep.save(isoTx);
        return inquiry;
    }
    public InquiryCardDto getCardNo(String accNo) {
        Customer entity= cusRep.findByInquiry(accNo);
        InquiryCardDto inquiry = new InquiryCardDto();
        inquiry.setCardNo(entity.getCardNo());

        Transaction tx = new Transaction();
        Date date=java.util.Calendar.getInstance().getTime();
        Random rand = new Random();
        Integer number = rand.nextInt(1000000000) + 1;
        Gson gson = new Gson();
        tx.setAcctNo(inquiry.getAcctNo());
        tx.setBenId(inquiry.getCardNo());
        tx.setDateTime(date);
        tx.setTrace(number);
        tx.setType("inquiry_card");
        tranRep.save(tx);

        String jsonInquiry = gson.toJson(inquiry);
        Iso8583 iso = new Iso8583();
        iso.setJson(jsonInquiry);
        iso8583Rep.save(iso);

        String jsonTx = gson.toJson(tx);
        Iso8583 isoTx = new Iso8583();
        isoTx.setJson(jsonTx);
        iso8583Rep.save(isoTx);


        return inquiry;
    }
}
