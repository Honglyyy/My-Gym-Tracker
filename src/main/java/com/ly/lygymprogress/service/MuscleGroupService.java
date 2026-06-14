package com.ly.lygymprogress.service;

import com.ly.lygymprogress.model.MuscleGroups;
import com.ly.lygymprogress.repository.MuscleGroupsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MuscleGroupService {
    private final MuscleGroupsRepository muscleGroupsRepository;

    public List<MuscleGroups> findMuscleGroups(){
        return muscleGroupsRepository.findAll();
    }

}
