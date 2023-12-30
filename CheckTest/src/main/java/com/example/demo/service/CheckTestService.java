package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.CheckTestRequest;
import com.example.demo.entity.CheckTestEntity;
import com.example.demo.repository.CheckTestRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CheckTestService {
  /**
   * ユーザー情報 Repository
   */
  @Autowired
  private CheckTestRepository checkTestRepository;

  /**
   * ユーザー情報 全検索
   * @return 検索結果
   */
  public List<CheckTestEntity> searchAll() {
    return checkTestRepository.findAll();
  }

  /**
   * ユーザー情報 新規登録
   * @param user ユーザー情報
   */
  public void create(CheckTestRequest checkTestRequest) {
	  CheckTestEntity checkTest = new CheckTestEntity();
	  checkTest.setName(checkTestRequest.getName());
	  checkTest.setKana(checkTestRequest.getKana());
	  checkTest.setEmail(checkTestRequest.getEmail());
	  checkTest.setPassword(checkTestRequest.getPassword());
	  checkTestRepository.save(checkTest);
	}
}