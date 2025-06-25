package com.example.Service;

import com.example.domain.entity.UserEntity;
import com.example.enums.AttendanceType;

public interface AttendanceSummaryService {
	void updateSummary(UserEntity userEntity, AttendanceType type);
}