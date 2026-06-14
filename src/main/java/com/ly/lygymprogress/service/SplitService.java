package com.ly.lygymprogress.service;

import com.ly.lygymprogress.dto.SplitRequestDto;
import com.ly.lygymprogress.dto.SplitResponseDto;
import com.ly.lygymprogress.mapper.SplitMapper;
import com.ly.lygymprogress.model.Exercises;
import com.ly.lygymprogress.model.SplitSession;
import com.ly.lygymprogress.model.Splits;
import com.ly.lygymprogress.repository.ExercisesRepository;
import com.ly.lygymprogress.repository.SplitsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SplitService {
    private final SplitsRepository splitsRepository;
    private final SplitMapper splitMapper;
    private final ExercisesRepository exercisesRepository;

    public List<SplitResponseDto> findSplits(){
        return splitsRepository.findAll().stream().map(splitMapper::toDto).toList();
    }

    public SplitResponseDto addSplit(SplitRequestDto dto){

        Splits split = new Splits();
        split.setSplitName(dto.splitName());
        
        List<SplitSession> sessions = dto.sessions().stream()
                .map(sessionDto -> {
                    SplitSession session = new SplitSession();
                    session.setSessionName(sessionDto.sessionName());
                    session.setExercises(findExercises(sessionDto.exerciseIds()));
                    session.setSplit(split);
                    return session;
                }).toList();
        
        split.setSessions(sessions);

        splitsRepository.save(split);

        return splitMapper.toDto(split);
    }

    public SplitResponseDto updateSplit(Long id, SplitRequestDto dto){
        Splits existingSplit = splitsRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Split is not found!!"));

        existingSplit.setSplitName(dto.splitName());
        
        // Clear existing sessions and add new ones
        existingSplit.getSessions().clear();
        List<SplitSession> sessions = dto.sessions().stream()
                .map(sessionDto -> {
                    SplitSession session = new SplitSession();
                    session.setSessionName(sessionDto.sessionName());
                    session.setExercises(findExercises(sessionDto.exerciseIds()));
                    session.setSplit(existingSplit);
                    return session;
                }).toList();
        existingSplit.getSessions().addAll(sessions);

        splitsRepository.save(existingSplit);

        return splitMapper.toDto(existingSplit);
    }

    public void deleteSplit(Long id){
        Splits existingSplit = splitsRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Split is not found!!"));

        splitsRepository.deleteById(id);
    }

    private List<Exercises> findExercises(List<Long> exerciseIds) {
        if (exerciseIds == null || exerciseIds.isEmpty()) {
            return Collections.emptyList();
        }

        List<Exercises> exercises = exercisesRepository.findAllById(exerciseIds);
        if (exercises.size() != exerciseIds.size()) {
            throw new RuntimeException("One or more exercises were not found");
        }

        return exercises;
    }
}
