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
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "pass_word")
    private String passWord;
    @Column(name = "phone_Number")
    private String phoneNumber;
    private String email;
    private String address;
    @Column(name = "create_Date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createDate;
    private boolean status;

    @ManyToOne
    @JoinColumn(name="id_Role")
    private Role role;

    @ManyToOne
    @JoinColumn(name="id_Branch")
    private Branch branch1;

    public Staff(String userName, String passWord, String phoneNumber, String email, String address, Date createDate, boolean status, Role role, Branch branch1) {
        this.userName = userName;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.createDate = createDate;
        this.status = status;
        this.role = role;
        this.branch1 = branch1;
    }
}
