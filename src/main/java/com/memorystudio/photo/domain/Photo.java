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
    private Long id;

    @Column
    private String dir;

    @Column
    private String date;

    @ManyToOne
    @JoinColumn(name = "id")
    private GroupMember groupMember;
}
