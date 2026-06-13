package com.ly.lygymprogress.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Splits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String splitName;

    @OneToMany(mappedBy = "split")
    private List<WorkoutSessions> workoutSessions;
}
