package com.woori.backend.stamp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StampRepository extends JpaRepository<Stamp, Long> {

    Optional<Stamp> findByUser_IdAndCafe_Id(Long userId, Long cafeId);

    Page<Stamp> findByCafe_Id(Long cafeId, Pageable pageable);

    Page<Stamp> findByUser_id(Long userId, Pageable pageable);

}
