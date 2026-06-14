package com.ly.lygymprogress.service;

import com.ly.lygymprogress.dto.WorkoutSessionRequestDto;
import com.ly.lygymprogress.dto.WorkoutSessionResponseDto;
import com.ly.lygymprogress.mapper.WorkoutSessionMapper;
import com.ly.lygymprogress.model.Splits;
import com.ly.lygymprogress.model.WorkoutSessions;
import com.ly.lygymprogress.repository.SplitsRepository;
import com.ly.lygymprogress.repository.WorkoutSessionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutSessionService {
    private final WorkoutSessionsRepository workoutSessionsRepository;
    private final WorkoutSessionMapper workoutSessionMapper;
    private final SplitsRepository splitsRepository;

    public List<WorkoutSessionResponseDto> findWorkoutSessions(){
        return workoutSessionsRepository.findAll().stream().map(workoutSessionMapper::toDto).toList();
    }

    public WorkoutSessionResponseDto addWorkoutSession(WorkoutSessionRequestDto dto){
        Splits split = splitsRepository.findById(dto.splitId())
                .orElseThrow(()-> new RuntimeException("Split not found"));
        WorkoutSessions workoutSession = new WorkoutSessions();
        workoutSession.setSessionName(dto.sessionName());
        workoutSession.setSplit(split);

        workoutSessionsRepository.save(workoutSession);

        return workoutSessionMapper.toDto(workoutSession);
    }

    public WorkoutSessionResponseDto updateWorkoutSession(Long id, WorkoutSessionRequestDto dto){
        Splits split = splitsRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Split not found"));
        WorkoutSessions workoutSession = new WorkoutSessions();
        workoutSession.setSessionName(dto.sessionName());
        workoutSession.setSplit(split);

        workoutSessionsRepository.save(workoutSession);
        return workoutSessionMapper.toDto(workoutSession);
    }

    public void deleteWorkoutSession(Long id){
        workoutSessionsRepository.deleteById(id);
    }
}
