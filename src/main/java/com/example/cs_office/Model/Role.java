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
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String nameRole;
    @Column(name = "create_Date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createDate;
    private boolean status;

    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    private Collection<Staff> staff;

    public Role(String nameRole, Date createDate, boolean status) {
        this.nameRole = nameRole;
        this.createDate = createDate;
        this.status = status;
    }

    public Role(String nameRole, Date createDate, boolean status, Collection<Staff> staff) {
        this.nameRole = nameRole;
        this.createDate = createDate;
        this.status = status;
        this.staff = staff;
    }
}
