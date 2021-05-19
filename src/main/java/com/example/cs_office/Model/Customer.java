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
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "phone_Number")
    private String phoneNumber;
    private String email;
    @Column(name = "pass_Word")
    private String password;
    @Column(name = "first_Name")
    private String fisrtName;
    @Column(name = "last_Name")
    private String lastName;
    private String address;
    @Column(name = "create_Date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createDate;
    private boolean status;

    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private Collection<Order> orders;

    public Customer(String phoneNumber, String email, String password, String fisrtName, String lastName, String address, Date createDate, boolean status) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.address = address;
        this.createDate = createDate;
        this.status = status;
    }

    public Customer(String email) {
        this.email = email;
    }
}
