package com.ly.lygymprogress.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Exercises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exercise_name")
    private String exerciseName;

    @ManyToOne
    private MuscleGroups muscleGroup;

    @ManyToOne
    private WorkoutSessions workoutSession;

    @OneToMany(mappedBy = "exercise")
    private List<WorkoutSets> workoutSets;
}
