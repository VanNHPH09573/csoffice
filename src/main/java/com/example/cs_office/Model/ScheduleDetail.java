package com.example.cs_office.Model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "scheduledetail")
public class ScheduleDetail {

    @Id
    @GeneratedValue
    private int id;
    private String startTime ;
    private String endTime;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date date;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date editDate;
    @Column(name = "create_Date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createDate;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "id_OrderDetail")
    private OrderDetail orderDetail1;

    @ManyToOne
    @JoinColumn(name = "id_Shedule")
    private Schedule schedule;
}
