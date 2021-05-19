package com.example.cs_office.Model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue
    private int id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date startDate;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date endDate;
    @Column(name = "create_Date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createDate;
    private boolean status;

    @OneToMany(mappedBy = "schedule",fetch = FetchType.EAGER)
    private Collection<ScheduleDetail> scheduleDetails;

    public Schedule(Date startDate, Date endDate, Date createDate, boolean status, Collection<ScheduleDetail> scheduleDetails) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.createDate = createDate;
        this.status = status;
        this.scheduleDetails = scheduleDetails;
    }
}
