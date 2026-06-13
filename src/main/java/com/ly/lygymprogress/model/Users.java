package com.ly.lygymprogress.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private Long age;
    @Column(name = "weight_before")
    private Double weightBefore;
    @Column(name = "weight_after")
    private Double weightAfter;
    private Double height;
}
