package com.memorystudio.groupMember.Domain;

import com.memorystudio.group.Domain.Group;
import com.memorystudio.member.domain.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GroupMember {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
