package com.woori.backend.stamp;

import com.woori.backend.cafe.Cafe;
import com.woori.backend.global.common.BaseTimeEntity;
import com.woori.backend.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "stamps")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stamp extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer count = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_id")
    private Cafe cafe;

    public Stamp(User user, Cafe cafe) {
        this.user = user;
        this.cafe = cafe;
        user.getStamps().add(this);
        cafe.getStamps().add(this);
    }

    public void addStamp() {
        this.count++;
    }

    public void removeStamp() {
        this.count--;
    }

    public void useStamp(int amount) {
        if (this.count < amount) {
            throw new IllegalArgumentException("사용 스탬프 부족 오류");
        }
        this.count -= amount;
    }
}
