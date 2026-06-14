package com.ly.lygymprogress.service;

import com.ly.lygymprogress.dto.SplitRequestDto;
import com.ly.lygymprogress.dto.SplitResponseDto;
import com.ly.lygymprogress.mapper.SplitMapper;
import com.ly.lygymprogress.model.Splits;
import com.ly.lygymprogress.repository.SplitsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SplitService {
    private final SplitsRepository splitsRepository;
    private final SplitMapper splitMapper;

    public List<SplitResponseDto> findSplits(){
        return splitsRepository.findAll().stream().map(splitMapper::toDto).toList();
    }

    public SplitResponseDto addSplit(SplitRequestDto dto){

        Splits split = new Splits();
        split.setSplitName(dto.splitName());

        splitsRepository.save(split);

        return splitMapper.toDto(split);
    }

    public SplitResponseDto updateSplit(Long id, SplitRequestDto dto){
        Splits existingSplit = splitsRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Split is not found!!"));

        existingSplit.setSplitName(dto.splitName());

        splitsRepository.save(existingSplit);

        return splitMapper.toDto(existingSplit);
    }

    public void deleteSplit(Long id){
        Splits existingSplit = splitsRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Split is not found!!"));

        splitsRepository.deleteById(id);
    }
}
