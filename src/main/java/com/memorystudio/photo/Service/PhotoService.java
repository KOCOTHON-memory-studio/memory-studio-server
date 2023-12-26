package com.memorystudio.photo.Service;

import com.memorystudio.groupMember.Domain.GroupMember;
import com.memorystudio.groupMember.Domain.GroupMemberRepository;
import com.memorystudio.photo.Dto.*;
import com.memorystudio.photo.domain.Photo;
import com.memorystudio.photo.domain.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final GroupMemberRepository groupMemberRepository;

    public Photo save(PhotoSaveDTO request) {
        GroupMember groupMember = groupMemberRepository.findById(request.getGroupMemberId()).
                orElseThrow(IllegalArgumentException::new);
        return photoRepository.save(new Photo(request, groupMember));
    }

    public List<PhotoResponseDTO> getPhotoMonth(PhotoMonthRequestDTO request) {
        return photoRepository.findAllByMonthAndGroupId(request.getMonth(), request.getGroupId()).stream()
                .map(PhotoResponseDTO::new)
                .toList();
    }

    public List<PhotoDetailResponseDTO> getPhotoDetail(PhotoDetailRequestDTO request) {

        List<PhotoDetailResponseDTO> photoLinkedList = photoRepository
                .findAllByMonthAndDateAndGroupId(
                        request.getMonth(),
                        request.getDate(),
                        request.getGroupId()).stream()
                .map(PhotoDetailResponseDTO::new)
                .toList();
        return photoLinkedList;
    }
}
