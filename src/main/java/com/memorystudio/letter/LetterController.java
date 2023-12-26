package com.memorystudio.letter;

import com.memorystudio.letter.dto.LetterDto;
import com.memorystudio.letter.dto.LetterListDTO;
import com.memorystudio.letter.dto.LetterResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LetterController {

    private final LetterService letterService;

    @GetMapping("/api/letter")
    public LetterResponseDTO getLetter(@RequestParam Long letterId) {
        return letterService.getLetter(letterId);
    }

    @PostMapping("/api/letter")
    public void saveLetter(@RequestBody LetterDto letterDto) {
        letterService.saveLetter(letterDto);
    }

    @GetMapping("/api/letters")
    public List<LetterListDTO> getLetterList(@RequestParam Long userId) {
        return letterService.getLetterList(userId);
    }
}
