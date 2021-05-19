package com.example.cs_office.Model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="room")
public class Room {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String nameRoom;
    @Column(name = "create_Date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createDate;
    private boolean status;

    @OneToMany(mappedBy = "room",fetch = FetchType.EAGER)
    private Collection<OrderDetail> orderDetails;

    @ManyToOne
    @JoinColumn(name = "id_Branch")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "id_TypeRoom")
    private TypeRoom typeRoom;
}
