package com.example.cs_office.Model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "priceTypeRoom")
public class PriceTypeRoom {
    @Id
    @GeneratedValue
    private int id;
    private double value;
    @Column(name = "create_Date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createDate;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "id_TypeRoom")
    private TypeRoom typeRoom1;
}
