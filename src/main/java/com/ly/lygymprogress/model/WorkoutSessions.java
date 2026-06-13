package com.ly.lygymprogress.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkoutSessions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "session_name")
    private String sessionName;

    @ManyToOne
    private Splits split;

    @OneToMany(mappedBy = "workoutSession")
    private List<Exercises> exercises;
}
