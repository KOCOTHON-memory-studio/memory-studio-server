package com.memorystudio.photo.domain;

import com.memorystudio.groupMember.Domain.GroupMember;
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

    private String name;
    private String dir;
    private String date;

    @ManyToOne
    @JoinColumn(name = "group_member_id")
    private GroupMember groupMember;
}
