package com.example.demo.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;





/**
 * ユーザー情報 Entity
 */

@Data
@Entity
@Table(name = "user", schema = "public")
public class UserEntity  {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    //2行追加
    private Long id;

    /**
     * 名前
     */
    @Column(name = "name")
    private String name;

    /**
     * 住所
     */
    @Column(name = "address")
    private String address;

    /**
     * 電話番号
     */
    //2行追加
    @Column(name = "phone")
    private String phone;

    /**
     * 更新日時
     */
    //2行追加
    @Column(name = "update_date")
    private Date update_Date;

    /**
     * 登録日時
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 削除日時
     */
    @Column(name = "delete_date")
    private Date deleteDate;
}