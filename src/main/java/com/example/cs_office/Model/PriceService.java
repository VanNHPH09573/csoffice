package com.example.cs_office.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="priceService")
public class PriceService {

    @Id
    @GeneratedValue
    private int id;
    private double value;
    @Column(name = "create_Date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createDate;
    private boolean status;

    @ManyToMany
    @JoinColumn(name="id_Service")
    private Service service;

    public PriceService(double value, Date createDate, boolean status, Service service) {
        this.value = value;
        this.createDate = createDate;
        this.status = status;
        this.service = service;
    }
}
