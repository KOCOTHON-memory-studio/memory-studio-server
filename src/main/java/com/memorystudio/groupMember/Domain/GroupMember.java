package com.memorystudio.groupMember.Domain;

import com.memorystudio.group.Domain.Group;
// import com.memorystudio.member.Domain.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GroupMember {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Group group;

//    @ManyToOne
//    @JoinColumn(name = "id")
//    private Member member;
}
