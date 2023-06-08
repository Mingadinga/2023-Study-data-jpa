package study.datajpa.entity;

import jakarta.persistence.*;
import lombok.*;

// JPA는 프록시를 사용하므로 표준 스펙으로 기본 생성자가 하나 필요한데
// protected로 열어서 최대한 숨긴다
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter @Setter
@ToString(of = {"id", "username", "age"}) // 연관관계 필드 참조시 무한루프
@NamedEntityGraph(name = "Member.all", attributeNodes = @NamedAttributeNode("team"))
public class Member extends BaseEntity {

    @Id @GeneratedValue
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String username) {
        this(username, 0);
    }

    public Member(String username, int age) {
        this(username, age, null);
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if (team != null) {
            changeTeam(team);
        }
    }

    // 양방향 연관관계 편의 메소드
    private void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }


}
