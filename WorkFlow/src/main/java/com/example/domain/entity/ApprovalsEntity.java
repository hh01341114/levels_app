package com.example.domain.entity;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.domain.enums.ApprovalsDecision;

import lombok.Data;


/**
 * 承認用エンティティ
 */
@Data
@Entity
@Table(name = "approvals")
public class ApprovalsEntity {
	
	/**
	 * 主キー（id）
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * UserEntityとのリレーション (外部キーにid)を設定
	 */
	@ManyToOne
	@JoinColumn(name = "request_id", referencedColumnName = "id")
	private RequestEntity request;
	
	/**
	 * 承認者idS
	 */
	@ManyToOne
	@JoinColumn(name = "approver_id", referencedColumnName = "id")
	private UserEntity approver;
	
	/**
	 * 管理者用承認権限
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "decision")
	private ApprovalsDecision decision;
	
	/**
	 * 承認アクションの時間
	 */
	@Column(name = "decided_at", nullable = false)
	private LocalDateTime decidedAt;
}
