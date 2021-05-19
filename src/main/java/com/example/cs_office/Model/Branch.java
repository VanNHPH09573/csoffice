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
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;
    @Column(name = "create_Date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createDate;
    private boolean status;

    @OneToMany(mappedBy = "branch",fetch = FetchType.EAGER)
    private Collection<Room> rooms;

    @OneToMany(mappedBy = "branch1",fetch = FetchType.EAGER)
    private Collection<Staff> staff;

    public Branch(String name, String address, Date createDate, boolean status) {
        this.name = name;
        this.address = address;
        this.createDate = createDate;
        this.status = status;
    }
}
