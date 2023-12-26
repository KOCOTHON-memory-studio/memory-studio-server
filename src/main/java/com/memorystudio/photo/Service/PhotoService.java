package com.memorystudio.photo.Service;

import com.memorystudio.groupMember.Domain.GroupMember;
import com.memorystudio.groupMember.Domain.GroupMemberRepository;
import com.memorystudio.photo.Dto.*;
import com.memorystudio.photo.domain.Photo;
import com.memorystudio.photo.domain.PhotoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final GroupMemberRepository groupMemberRepository;

    private final String PATH = "/home/ec2-user/img/";

//    public Photo save(PhotoSaveDTO request) {
//        GroupMember groupMember = groupMemberRepository.findById(request.getGroupMemberId()).
//                orElseThrow(IllegalArgumentException::new);
//        return photoRepository.save(new Photo(request, groupMember));
//    }

    public List<PhotoResponseDTO> getPhotoMonth(String month, Long groupId) {
        return photoRepository.findAllByMonthAndGroupId(month, groupId).stream()
                .map(PhotoResponseDTO::new)
                .toList();
    }

    public List<PhotoDetailResponseDTO> getPhotoDetail(String month, String date, Long groupId) {

        List<PhotoDetailResponseDTO> photoList = photoRepository
                .findAllByMonthAndDateAndGroupId(
                        month, date, groupId).stream()
                .map(PhotoDetailResponseDTO::new)
                .toList();
        return photoList;
    }

    public List<PhotoOnlyDTO> getPhotoGallery(Long userId) {
        return photoRepository.findAllByUserId(userId).stream()
                .map(PhotoOnlyDTO::new)
                .toList();
    }

    public Photo save(String month, String date, Long groupMemberId, MultipartFile img) throws IOException {
        String uuid = UUID.randomUUID().toString();
        String fullPath = PATH + uuid + ".png";
        Path savePath = Paths.get(fullPath);
        img.transferTo(savePath);
        String url = "http://3.36.63.145:8080/img?url=" + uuid;

        GroupMember groupMember = groupMemberRepository.findById(groupMemberId)
                .orElseThrow(IllegalArgumentException::new);
        Photo photo = Photo.builder()
                .month(month)
                .date(date)
                .groupMember(groupMember)
                .groupId(groupMember.getGroup().getId())
                .url(url).build();
        photoRepository.save(photo);
        return photo;
    }
}
