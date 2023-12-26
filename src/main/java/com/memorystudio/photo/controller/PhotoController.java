package com.memorystudio.photo.controller;

import com.memorystudio.photo.Dto.*;
import com.memorystudio.photo.Service.PhotoService;
import com.memorystudio.photo.domain.Photo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;

    @GetMapping("/api/photo")
    public List<PhotoResponseDTO> getPhotoMonth(@RequestParam String month, @RequestParam Long groupId) {
        return photoService.getPhotoMonth(month, groupId);
    }

    @PostMapping("/api/photo")
    public Photo savePhoto(@RequestBody PhotoSaveDTO request) {
        return photoService.save(request);
    }

    @GetMapping("/api/photodetail")
    public List<PhotoDetailResponseDTO> getPhotoDetail(@RequestBody PhotoDetailRequestDTO request) {
        return photoService.getPhotoDetail(request);
    }
}
