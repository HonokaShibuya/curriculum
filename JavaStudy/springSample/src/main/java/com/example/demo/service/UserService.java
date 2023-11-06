package com.example.demo.service;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
    /**
     * ユーザー情報 Repository
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * ユーザー情報 全検索
     * @return  検索結果
     */
    public List<UserEntity> searchAll() {
        //1行追加
        return userRepository.findAll();

    }
    
    /**
     * ユーザー情報 主キー検索
     * @return  検索結果
     */
    public UserEntity findById(Long id) {
        //実装1行
       return userRepository.findById(id).get();
    }

    /**
     * ユーザー情報 新規登録
     * @param  user ユーザー情報
     */
    public void create(UserRequest userRequest) {
        Date now = new Date();
        UserEntity user = new UserEntity();
                        //実装2行
        user.setName(userRequest.getName());
        user.setAddress(userRequest.getAddress());
        user.setPhone(userRequest.getPhone());
        user.setCreateDate(now);
        user.setUpdateDate(now);
                       //保存するメソッド実装1行
        userRepository.save(user);
  }
    
    /**
     * ユーザー情報 更新
     * @param  user ユーザー情報
     */
    public void update(UserUpdateRequest userUpdateRequest) {
//実装6行
     UserEntity user = findById(userUpdateRequest.getId());
     user.setAddress(userUpdateRequest.getAddress());
     user.setName(userUpdateRequest.getName());
     user.setPhone(userUpdateRequest.getPhone());
     user.setUpdateDate(new Date());
     userRepository.save(user);
    }
    
    /**
     * ユーザー情報 物理削除
     * @param  id ユーザーID
     */
    public void delete(Long id) {
        //実装2行
      UserEntity user = findById(id);
      userRepository.delete(user);
    }    
    
}
