package study.datajpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class JpaBaseEntity {
    @Column(updatable = false) // 불변
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @PrePersist // 등록 전
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createdDate = now;
        updatedDate = now;
    }

    @PreUpdate // 수정 전
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
    }
}
