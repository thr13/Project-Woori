package com.woori.backend.user;

import com.woori.backend.global.common.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@RequiredArgsConstructor
public class User {
    @Id
    private final Long id;
    private final String email;
    private final String password;
    private final String name;
    private final Role role;
}
