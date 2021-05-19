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
@Table(name = "evaluate")
public class Evaluate {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "id_UserCreate")
    private int idUserCreate;
    private int level;
    private String content;
    @Column(name = "create_Date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createDate;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "id_Order")
    private Order order1;

    public Evaluate(int idUserCreate, int level, String content, Date createDate, boolean status, Order order1) {
        this.idUserCreate = idUserCreate;
        this.level = level;
        this.content = content;
        this.createDate = createDate;
        this.status = status;
        this.order1 = order1;
    }
}
