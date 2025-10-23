package com.woori.backend.cafe;

import com.woori.backend.stamp.Stamp;
import com.woori.backend.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "cafes")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cafe", cascade = CascadeType.ALL)
    private List<Stamp> stamps = new ArrayList<>();

    public Cafe(String name, String address, User user) {
        this.name = name;
        this.address = address;
        this.user = user;
        user.getCafes().add(this);
    }

    public void updateCafeInfo(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
