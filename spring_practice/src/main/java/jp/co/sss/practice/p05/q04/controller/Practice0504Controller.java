package jp.co.sss.practice.p05.q04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0504Controller {
	@Autowired
	FruitsSeasonRepository repository;

	@RequestMapping(path = "/fruits/search/input")
	String input() {
		return "practice05/04/fruits_select_season";
	}

	@RequestMapping("/fruits/search/result")
	String result(Integer season, Model model) {

		if (season < 13) {

			model.addAttribute("string", season + "月");

			model.addAttribute(
					"ans",
					repository.findBySeasonMonth(season));

		} else {

			model.addAttribute("string", "通年");

			model.addAttribute(
					"ans",
					repository.findAll());

		}

		return "practice05/04/fruits_list";
	}

}
