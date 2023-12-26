package com.memorystudio.photo.domain;

import com.memorystudio.groupMember.Domain.GroupMember;
import com.memorystudio.photo.Dto.PhotoSaveDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Builder
public class Photo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private Long id;

    private String url;
    private String month;
    private String date;
    private Long groupId;

    @ManyToOne
    @JoinColumn(name = "group_member_id")
    private GroupMember groupMember;


    public Photo(PhotoSaveDTO request, GroupMember groupMember) {
        this.groupMember = groupMember;
        this.month = request.getMonth();
        this.date = request.getDate();
        this.groupId = groupMember.getGroup().getId();
    }
}
