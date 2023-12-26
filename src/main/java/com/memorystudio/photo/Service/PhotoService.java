package com.memorystudio.photo.Service;

import com.memorystudio.photo.Dto.PhotoDto;
import com.memorystudio.photo.domain.Photo;
import com.memorystudio.photo.domain.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PhotoService {

    private final String PATH = "/Users/w/Downloads/memorystudio/photo/";


    private final PhotoRepository photoRepository;

    public PhotoDto getPhoto(Long id) {
        Optional<Photo> optionalPhoto = photoRepository.findById(id);
        if (optionalPhoto.isPresent()) {
            return PhotoDto.builder()
                    .id(optionalPhoto.get().getId())
                    .dir(optionalPhoto.get().getDir())
                    .date(optionalPhoto.get().getDate())
                    .groupMember(optionalPhoto.get().getGroupMember().getId())
                    .build();
        } else {
            throw new RuntimeException("no Photo");
        }
    }


    public String save(MultipartFile file) throws IOException {
        String filePath = PATH + file.getOriginalFilename();
        Photo photo = photoRepository.save(
                Photo.builder()
                        .name(file.getOriginalFilename())
                        .dir(filePath)
                        .build()
        );

        // 파일 결로
        file.transferTo(new File(filePath));
        if (photo != null) {
            return "file uploaded successfully! filePath : " + filePath;
        }
        return null;
    }
}
