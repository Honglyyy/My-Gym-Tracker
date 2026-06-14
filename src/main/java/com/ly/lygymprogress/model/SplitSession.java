package com.ly.lygymprogress.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SplitSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sessionName;

    @ManyToOne
    @JoinColumn(name = "split_id")
    private Splits split;

    @ManyToMany
    @JoinTable(
            name = "split_session_exercises",
            joinColumns = @JoinColumn(name = "split_session_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    private List<Exercises> exercises;
}
