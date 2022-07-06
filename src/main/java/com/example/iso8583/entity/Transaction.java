package com.example.iso8583.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "acct_no")
    private String acctNo;

    @Column(name = "ben_id")
    private String benId;

    @Column(name = "card_no")
    private String cardNo;

    @Column(name = "date_time")
    private Date dateTime;

    @Column(name = "trace")
    private Integer trace;

    @Column(name = "type")
    private String type;

}
