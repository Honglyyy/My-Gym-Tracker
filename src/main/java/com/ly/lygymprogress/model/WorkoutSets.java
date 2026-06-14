package com.ly.lygymprogress.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkoutSets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Exercises exercise;

    @ManyToOne
    private WorkoutSessions workoutSession;

    private String reps;
    private String weight;
}
