package com.example.iso8583.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "acct_no")
    private String acctNo;

    @Column(name = "ben_id")
    private String benId;

    @Column(name = "card_no")
    private String cardNo;

    @Column(name =  "name_customer")
    private String nameCustomer;


}