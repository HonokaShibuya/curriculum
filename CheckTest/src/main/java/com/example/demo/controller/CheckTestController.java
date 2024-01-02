package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.CheckTestRequest;
import com.example.demo.entity.CheckTestEntity;
import com.example.demo.service.CheckTestService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class CheckTestController {

	/**
	 * ユーザー情報 Service
	 */
	@Autowired
	private CheckTestService checkTestService;

	/**
	 * ユーザー新規登録画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping("CTRegistration")
	public String displayAdd(Model model) {
		model.addAttribute("checkTestRequest", new CheckTestRequest());
		return "CTRegistration";
	}

	/**
	 * ユーザー情報一覧画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping("CTList")
	public String displayList(Model model) {
		List<CheckTestEntity> CTList = checkTestService.searchAll();
		model.addAttribute("CTList", CTList);
		return "CTList";
	}

	/**
	 * ユーザー新規登録
	 * @param userRequest リクエストデータ
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@PostMapping("/CTRsgistration/create")
	public String create(@Validated @ModelAttribute CheckTestRequest checkTestRequest, BindingResult result, Model model) {

		if (result.hasErrors()) {
			// 入力チェックエラーの場合

			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "CTRegistration";
		}
		// ユーザー情報の登録
		checkTestService.create(checkTestRequest);
		return "CTList";
	}

	/**
	 * ユーザー情報詳細画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@GetMapping("/CTEditDelete/{user_id}")
	public String displayView(@PathVariable Integer id, Model model) {
		return "CTEditDelete";
	}

	/**
	 * ユーザー編集画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー編集画面
	 */
	@GetMapping("/CTEdit/{user_id}")
	public String displayEdit(@PathVariable Integer user_id, Model model) {
		CheckTestEntity checkTestEntity = checkTestService.findById(user_id);
		CheckTestRequest checkTestRequest = new CheckTestRequest();
		checkTestRequest.setUser_id(checkTestEntity.getUser_id());
		checkTestRequest.setName(checkTestEntity.getName());
		checkTestRequest.setKana(checkTestEntity.getKana());
		checkTestRequest.setEmail(checkTestEntity.getEmail());
		checkTestRequest.setPassword(checkTestEntity.getPassword());
		model.addAttribute("checkTestRequest", checkTestRequest);
		return "CTEditDelete";
	}
	/**
	 * ユーザー更新
	 * @param userRequest リクエストデータ
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@PostMapping("/CTEdit/update")
	public String update(@Validated @ModelAttribute CheckTestRequest checkTestRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "CTEditDelete";
		}
		// ユーザー情報の更新
		checkTestService.update(checkTestRequest);
		return "CTList";
	}

	/**
	 * ユーザー情報削除
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@GetMapping("/CTDelete/{user_id}")
	public String delete(@PathVariable Integer user_id, Model model) {
		// ユーザー情報の削除
		checkTestService.delete(user_id);
		return "CTList";
	}
}