package jp.co.sss.practice.p05.q06.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.form.FruitsSeasonForm;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0506Controller {

	@Autowired
	FruitsSeasonRepository repository;

	@RequestMapping(path = "/fruits/update")
	String update(Model model) {
		List<FruitsSeason> fruits = repository.findAll();

		List<FruitsSeasonBean> beans = new ArrayList<>();

		for (FruitsSeason fruit : fruits) {
			FruitsSeasonBean bean = new FruitsSeasonBean();
			BeanUtils.copyProperties(fruit, bean);
			beans.add(bean);

			model.addAttribute("fruits", beans);
		}
		return "practice05/06/fruit_select";

	}

	@RequestMapping(path = "/fruits/update/input", method = RequestMethod.POST)
	String input(Integer fruitId, Model model) {
		FruitsSeason fruit = repository.getReferenceById(fruitId);

		FruitsSeasonBean bean = new FruitsSeasonBean();
		BeanUtils.copyProperties(fruit, bean);
		model.addAttribute("fruit", bean);
		return "practice05/06/fruit_input";
	}

	@RequestMapping(path = "/fruits/update/complete/{fruitId}", method = RequestMethod.POST)
	String complete(@PathVariable Integer fruitId, FruitsSeasonForm fruitForm, Model model) {
		FruitsSeason fruit = repository.getReferenceById(fruitId);
		BeanUtils.copyProperties(fruitForm, fruit, "fruitId");
		fruit = repository.save(fruit);
		FruitsSeasonBean bean = new FruitsSeasonBean();
		BeanUtils.copyProperties(fruit, bean);
		model.addAttribute("fruit", bean);
		return "practice05/06/fruit_detail";
	}

}
