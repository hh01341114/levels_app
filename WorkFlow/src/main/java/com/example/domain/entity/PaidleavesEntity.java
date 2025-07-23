package com.example.domain.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity userEntity;
	
	//有給付与日
	private Date grant_date;
	
	//有給失効日
	private Date revocation_date;
	
	//有給付与日数
	private Float days;
	
	//有給使用日数
	private Float used_days;
}