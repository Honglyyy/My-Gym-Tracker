package com.ly.lygymprogress.service;

import com.ly.lygymprogress.dto.MuscleGroupResponseDto;
import com.ly.lygymprogress.model.MuscleGroups;
import com.ly.lygymprogress.repository.MuscleGroupsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MuscleGroupService {
    private final MuscleGroupsRepository muscleGroupsRepository;

    public List<MuscleGroupResponseDto> findMuscleGroups(){
        return muscleGroupsRepository.findAll().stream()
                .map(mg -> MuscleGroupResponseDto.builder()
                        .id(mg.getId())
                        .muscleGroup(mg.getMuscleGroups())
                        .build())
                .toList();
    }

}
