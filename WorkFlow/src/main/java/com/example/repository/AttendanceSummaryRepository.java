package com.example.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.entity.AttendanceSummaryEntity;
import com.example.domain.entity.UserEntity;

/**
 * 勤怠サマリ情報（AttendanceSummaryEntity）を扱うリポジトリインターフェース
 * 
 */
@Repository
public interface AttendanceSummaryRepository extends JpaRepository<AttendanceSummaryEntity, Integer> {
	/**
	 * 指定したユーザーと勤務日に一致する勤怠サマリ情報を取得する
	 * @param userEntity
	 * @param workDate
	 * @return
	 */
	Optional<AttendanceSummaryEntity> findByUserAndWorkDate(UserEntity userEntity, LocalDate workDate);
	
	/**
	 * 指定したユーザーの勤怠サマリ情報を、勤務日の降順で全件取得する
	 * @param userEntity
	 * @return
	 */
	List<AttendanceSummaryEntity> findByUserOrderByWorkDateDesc(UserEntity userEntity);
}