package com.memorystudio.photo.Service;

import com.memorystudio.photo.Dto.PhotoDto;
import com.memorystudio.photo.domain.Photo;
import com.memorystudio.photo.domain.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PhotoService {
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

    public void savePhoto(PhotoDto photoDto) {
    }
}
