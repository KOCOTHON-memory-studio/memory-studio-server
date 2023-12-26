package com.memorystudio.photo.controller;

import com.memorystudio.photo.Dto.PhotoDetailResponseDTO;
import com.memorystudio.photo.Dto.PhotoOnlyDTO;
import com.memorystudio.photo.Dto.PhotoResponseDTO;
import com.memorystudio.photo.Dto.PhotoSaveDTO;
import com.memorystudio.photo.Service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class PhotoController {

    private final String PATH = "/home/ec2-user/img/";
    private final PhotoService photoService;

    @GetMapping("/api/photo")
    public List<PhotoResponseDTO> getPhotoMonth(@RequestParam String month, @RequestParam Long groupId) {
        return photoService.getPhotoMonth(month, groupId);
    }

    @PostMapping("/api/photo")
    public PhotoSaveDTO savePhoto(
            @RequestParam String month,
            @RequestParam String date,
            @RequestParam String groupMemberId,
            @RequestParam MultipartFile img
            ) throws IOException {
        return new PhotoSaveDTO(photoService.save(month, date, Long.parseLong(groupMemberId), img));
    }

    @GetMapping("/api/photodetail")
    public List<PhotoDetailResponseDTO> getPhotoDetail(@RequestParam String month, @RequestParam String date,
                                                       @RequestParam Long groupId) {
        return photoService.getPhotoDetail(month, date, groupId);
    }

    @GetMapping("/api/gallery")
    public List<PhotoOnlyDTO> getPhotoGallery(@RequestParam Long userId) {
        return photoService.getPhotoGallery(userId);
    }

    @GetMapping("/img")
    public ResponseEntity<byte[]> getImage(@RequestParam String url) {
        File file = new File(PATH + url + ".png");
        ResponseEntity<byte[]> result=null;
        try {
            HttpHeaders headers=new HttpHeaders();
            headers.add("Content-Type", Files.probeContentType(file.toPath()));
            result=new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),headers, HttpStatus.OK );
        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
