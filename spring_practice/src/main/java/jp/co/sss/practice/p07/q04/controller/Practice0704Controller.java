package jp.co.sss.practice.p07.q04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.practice.p07.entity.Type;
import jp.co.sss.practice.p07.repository.FruitsShopItemRepository;

@Controller
public class Practice0704Controller {
	@Autowired
	FruitsShopItemRepository repository;

	@RequestMapping("/fruits_shop/type/sort/bycount")
	String count(Model model) {
		List<Type> sortList = repository.findQuerySortByTypeCount();
		model.addAttribute("all", sortList);

		return "practice07/04/type_list";
	}

}
