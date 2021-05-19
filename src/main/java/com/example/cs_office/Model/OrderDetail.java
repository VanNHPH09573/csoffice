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
@Table(name="orderDetail")
public class OrderDetail {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "create_Date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createDate;
    private boolean status;

    @OneToMany(mappedBy = "orderDetail",fetch = FetchType.EAGER)
    private Collection<ServiceDetail> serviceDetails;

    @OneToMany(mappedBy = "orderDetail1",fetch = FetchType.EAGER)
    private Collection<ScheduleDetail> scheduleDetails;

    @OneToMany(mappedBy = "orderDetail2",fetch = FetchType.EAGER)
    private Collection<OrderHistory> orderHistories;

    @ManyToOne
    @JoinColumn(name="id_Order")
    private Order order;

    @ManyToOne
    @JoinColumn(name="id_Room")
    private Room room;
}
