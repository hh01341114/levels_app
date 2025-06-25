package com.example.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.entity.AttendanceSummaryEntity;
import com.example.domain.entity.UserEntity;

@Repository
public interface AttendanceSummaryRepository extends JpaRepository<AttendanceSummaryEntity, Integer> {
	Optional<AttendanceSummaryEntity> findByUserAndWorkDate(UserEntity userEntity, LocalDate workDate);
}