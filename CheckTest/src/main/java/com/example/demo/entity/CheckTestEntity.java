package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "ct_table")
public class CheckTestEntity {
  /**
   * ID
   */
  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer user_id;
  /**
   * 名前
   */
  @Column(name = "name")
  private String name;
  /**
   * フリガナ
   */
  @Column(name = "kana")
  private String kana;
  /**
   * メールアドレス
   */
  @Column(name = "email")
  private String email;
  /**
   * パスワード
   */
  @Column(name = "password")
  private String password;
}