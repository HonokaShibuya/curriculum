package com.example.demo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@SuppressWarnings("serial")
@Data
public class CheckTestRequest implements Serializable {

	@NotEmpty(message="名前を入力してください")
	private String name;

	@NotEmpty(message="フリガナを入力してください")
	private String kana;

	@NotEmpty(message="メールアドレスを入力してください")
	private String email;

	@NotEmpty(message="パスワードを入力してください")
	private String password;
}