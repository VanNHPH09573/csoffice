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
@Table(name = "datemaster")
public class DateMaster {
    @Id
    @GeneratedValue
    private int id;
    private String desc;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date date;
    @Column(name = "create_Date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createDate;
    private boolean status;

    public DateMaster(String desc, Date date, Date createDate, boolean status) {
        this.desc = desc;
        this.date = date;
        this.createDate = createDate;
        this.status = status;
    }
}
