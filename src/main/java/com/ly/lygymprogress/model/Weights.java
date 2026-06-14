package com.ly.lygymprogress.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Weights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "weight_before")
    private Double weightBefore;
    @Column(name = "weight_after")
    private Double weightAfter;

    @CreationTimestamp
    private Timestamp createdAt;

    @ManyToOne
    private Users user;
}
