package com.woori.backend.cafe;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CafeRepository extends JpaRepository<Cafe, Long> {

    Optional<Cafe> findByName(String name);

    List<Cafe> findByUser_Id(Long userId);

}
