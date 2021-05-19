package com.example.cs_office.Model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="orderHistory")
public class OrderHistory {

    @Id
    @GeneratedValue
    private int id;
    private String roomOLd;
    private String startTimeOld;
    private String endTimeOld;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date date;
    @Column(name = "create_Date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createDate;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "id_OrderDetail")
    public OrderDetail orderDetail2;

    public OrderHistory(String roomOLd, String startTimeOld, String endTimeOld, Date date, Date createDate, boolean status, OrderDetail orderDetail2) {
        this.roomOLd = roomOLd;
        this.startTimeOld = startTimeOld;
        this.endTimeOld = endTimeOld;
        this.date = date;
        this.createDate = createDate;
        this.status = status;
        this.orderDetail2 = orderDetail2;
    }
}
