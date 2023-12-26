package com.memorystudio.groupMember.Domain;

import com.memorystudio.group.Domain.Group;
// import com.memorystudio.member.Domain.Member;
import com.memorystudio.groupMember.dto.GroupMemberDTO;
import com.memorystudio.member.domain.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class GroupMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_memeber_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public GroupMember(Group group, Member member) {
        this.group = group;
        this.member = member;
    }
}
