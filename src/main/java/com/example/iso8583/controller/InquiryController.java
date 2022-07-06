package com.example.iso8583.controller;

import com.example.iso8583.model.InquiryDto;
import com.example.iso8583.res.Res;
import com.example.iso8583.service.CustomerSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class InquiryController {

    @Autowired
    CustomerSerivce customerService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(customerService.getAll());
    }

    @PutMapping("/inquiry")
    public ResponseEntity<?> getCustomerBin (@RequestBody InquiryDto accNo){
        try {
            return ResponseEntity.ok(new Res(customerService.getNumberNo(accNo.getAcctNo()),"customer information",true));
        }catch (Exception e){
            return ResponseEntity.ok(new Res("Does not exist",false));
        }
    }
    @PutMapping("/inquirycard")
    public ResponseEntity<?> getCustomerCard (@RequestBody InquiryDto accNo){
        try {
            return ResponseEntity.ok(new Res(customerService.getCardNo(accNo.getAcctNo()),"Card Information",true));
        }catch (Exception e){
            return ResponseEntity.ok(new Res("Does not exist",false));
        }

    }
}
