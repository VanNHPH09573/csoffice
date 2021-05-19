package com.example.cs_office.Model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "typeRoom")
public class TypeRoom {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String nameTypeRoom;
    @Column(name = "create_Date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createDate;
    private boolean status;

    @OneToMany(mappedBy = "typeRoom",fetch = FetchType.EAGER)
    private Collection<Room> rooms;

    @OneToMany(mappedBy = "typeRoom1",fetch = FetchType.EAGER)
    private Collection<PriceTypeRoom> priceTypeRooms;
}
