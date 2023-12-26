package com.memorystudio.photo.controller;

import com.memorystudio.photo.Dto.PhotoDto;
import com.memorystudio.photo.Service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoService photoService;

    @GetMapping("/api/photo")
    public PhotoDto getPhoto(@RequestParam Long id) {
        return photoService.getPhoto(id);
    }

    @PostMapping("/api/photo")
    public void savePhoto(@RequestBody PhotoDto photoDto) {
        photoService.savePhoto(photoDto);
    }
}
