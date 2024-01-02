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
   * ユーザー情報 主キー検索
   * @return 検索結果
   */
  public CheckTestEntity findById(Integer user_id) {
    return checkTestRepository.findById(user_id).get();
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

  /**
   * ユーザー情報 更新
   * @param user ユーザー情報
   */
  public void update(CheckTestRequest checkTestRequest) {
	  CheckTestEntity checkTestEntity = findById(checkTestRequest.getUser_id());
	  checkTestEntity.setName(checkTestRequest.getName());
	  checkTestEntity.setKana(checkTestRequest.getKana());
	  checkTestEntity.setEmail(checkTestRequest.getEmail());
	  checkTestEntity.setPassword(checkTestRequest.getPassword());
	  checkTestRepository.save(checkTestEntity);
  }

  /**
	 * ユーザー情報 物理削除
	 * @param id ユーザーID
	 */
	public void delete(Integer user_id) {
		CheckTestEntity checkTestEntity = findById(user_id);
		checkTestRepository.delete(checkTestEntity);
	}
}