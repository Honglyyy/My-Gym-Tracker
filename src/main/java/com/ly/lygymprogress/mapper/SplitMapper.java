package com.ly.lygymprogress.mapper;

import com.ly.lygymprogress.dto.SplitResponseDto;
import com.ly.lygymprogress.model.Splits;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SplitMapper {

    public SplitResponseDto toDto(Splits split){
        return SplitResponseDto.builder()
                .id(split.getId())
                .splitName(split.getSplitName())
                .workoutSessions(split.getWorkoutSessions())
                .build();
    }


}
