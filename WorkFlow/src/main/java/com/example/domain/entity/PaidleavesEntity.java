package com.example.domain.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

/**
 * 有給管理用のエンティティクラス
 */
@Data
@Entity
@Table(name = "paidleaves")
public class PaidleavesEntity {
	
	//主キー
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//外部キー、ユーザーid
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity userEntity;
	
	//有給付与日
	@Column(name = "grant_date")
	private LocalDate grantDate;
	
	//有給失効日
	@Column(name = "revocation_date")
	private LocalDate revocationDate;
	
	//有給付与日数
	private Float days;
	
	//有給使用日数
	@Column(name = "used_days")
	private Float usedDays;
}