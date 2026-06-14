package com.ly.lygymprogress.controller;

import com.ly.lygymprogress.dto.SplitRequestDto;
import com.ly.lygymprogress.dto.SplitResponseDto;
import com.ly.lygymprogress.service.SplitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SplitController {
    private final SplitService splitService;

    @GetMapping("/splits")
    ResponseEntity<List<SplitResponseDto>> findSplits(){
        return ResponseEntity.ok(splitService.findSplits());
    }

    @PostMapping("/splits")
    ResponseEntity<SplitResponseDto> addSplit(@RequestBody SplitRequestDto dto){return ResponseEntity.ok(splitService.addSplit(dto));}

    @PutMapping("/splits/{id}")
    ResponseEntity<SplitResponseDto> updateSplit(@PathVariable Long id, @RequestBody SplitRequestDto dto){return ResponseEntity.ok(splitService.updateSplit(id,dto));}

    @DeleteMapping("/splits/{id}")
    ResponseEntity<String> deleteSplit(@PathVariable Long id){
        splitService.deleteSplit(id);
        return ResponseEntity.ok("Split is deleted");
    }
}
