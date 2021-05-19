package com.example.cs_office.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="service")
public class Service {

    @Id
    @GeneratedValue
    private int id;
    @Column(name="id_PriceService")
    private String idPriceService;
    @Column(name="name")
    private String nameService;
    @Column(name = "create_Date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createDate;
    private boolean status;

    @OneToMany(mappedBy="service", fetch=FetchType.EAGER)
    private Collection<PriceService> priceServices;

    @OneToMany(mappedBy = "service1",fetch = FetchType.EAGER)
    private  Collection<ServiceDetail> serviceDetails;

    public Service(String idPriceService, String nameService, Date createDate, boolean status, Collection<PriceService> priceServices, Collection<ServiceDetail> serviceDetails) {
        this.idPriceService = idPriceService;
        this.nameService = nameService;
        this.createDate = createDate;
        this.status = status;
        this.priceServices = priceServices;
        this.serviceDetails = serviceDetails;
    }
}
