package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.entity.AttendanceEntity;

/**
 * アテンダンスリポシトリークラス
 * 勤怠打刻状況を管理するリポシトリークラス
 */
@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Integer> {
	// 特定のユーザーに紐づく勤怠履歴を取得（新しい順）
	List<AttendanceEntity> findByUserEntityIdOrderByAtDesc(Integer userId);
}