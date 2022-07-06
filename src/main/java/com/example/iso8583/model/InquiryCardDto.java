package com.example.iso8583.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InquiryCardDto {
    @JsonIgnore
    private String acctNo;
    private String cardNo;

}
