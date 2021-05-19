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
@Table(name="order")
public class Order {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "create_Date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createDate;
    private boolean status;

    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER)
    private Collection<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "order1",fetch = FetchType.EAGER)
    private Collection<Evaluate> evaluates;

    @ManyToOne
    @JoinColumn(name = "id_Customer")
    private Customer customer;
}
