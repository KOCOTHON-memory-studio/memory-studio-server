package com.memorystudio.photo.controller;

import com.memorystudio.photo.Dto.PhotoDto;
import com.memorystudio.photo.Service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;


    // TODO
    // PhotoService에서 파일 저장 위치 확인
    // 파일명을 어떻게 할지?, 파일 보내주면서 GroupMember 아이디를 같이 보내주실 수 있는지?


    @GetMapping("/api/photo")
    public PhotoDto getPhoto(@RequestParam Long id) {
        return photoService.getPhoto(id);
    }

    @PostMapping("/api/photo")
    public String savePhoto(MultipartFile file) throws IOException {
        return photoService.save(file);
    }
}
