package jp.co.sss.practice.p07.q02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jp.co.sss.practice.p07.entity.FruitsShopItem;
import jp.co.sss.practice.p07.entity.Type;
import jp.co.sss.practice.p07.repository.TypeRepository;

@Controller
public class Practice0702Controller {

	@Autowired
	TypeRepository repository;
	@Autowired
	EntityManager manager;
	@PersistenceContext
	private EntityManager entityManager;

	@RequestMapping("/fruits_shop/named/input")
	String showAll(Model model) {
		model.addAttribute("all", repository.findAll());
		return "practice07/02/search_input";
	}

	@RequestMapping("/fruits_shop/named/result")
	String result(Integer minPrice, Integer maxPrice, Integer typeId, Model model) {
		Type type = new Type();
		type.setTypeId(typeId);
		Query query = entityManager.createNamedQuery(
				"findNamedQueryByPriceRangeAndType");

		query.setParameter("min", minPrice);
		query.setParameter("max", maxPrice);
		query.setParameter("type", type);

		List<FruitsShopItem> items = query.getResultList();

		model.addAttribute("items", items);

		return "practice07/02/items_list";
	}

}
