package jp.co.sss.practice.p07.q03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.practice.p07.entity.FruitsShopItem;
import jp.co.sss.practice.p07.entity.Type;
import jp.co.sss.practice.p07.repository.FruitsShopItemRepository;
import jp.co.sss.practice.p07.repository.TypeRepository;

@Controller
public class Practice0703Controller {
	@Autowired
	FruitsShopItemRepository repository;
	@Autowired
	TypeRepository typeRepository;

	@RequestMapping("/fruits_shop/query/input")
	String input(Model model) {
		model.addAttribute("all", typeRepository.findAll());
		return "practice07/03/search_input";
	}

	@RequestMapping("/fruits_shop/query/result")
	String result(Integer minPrice, Integer maxPrice, Integer typeId, Model model) {
		Type type = new Type();
		type.setTypeId(typeId);
		List<FruitsShopItem> itemList = repository.findQueryByPriceRangeAndType(
				minPrice,
				maxPrice,
				type);

		model.addAttribute("itemList", itemList);
		return "practice07/03/items_list";
	}

}
