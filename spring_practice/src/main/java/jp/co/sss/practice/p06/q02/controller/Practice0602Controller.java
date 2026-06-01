package jp.co.sss.practice.p06.q02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.practice.p06.entity.Area;
import jp.co.sss.practice.p06.entity.FruitsArea;
import jp.co.sss.practice.p06.repository.AreaRepository;
import jp.co.sss.practice.p06.repository.FruitsAreaRepository;

@Controller
public class Practice0602Controller {

	@Autowired
	FruitsAreaRepository repository;

	@Autowired
	AreaRepository areaRepository;

	@RequestMapping(path = "/fruits/select/area")
	String all(Model model) {

		model.addAttribute("all", areaRepository.findAllByOrderByAreaIdAsc());
		return "practice06/02/area_select";
	}

	@RequestMapping(path = "/fruits/select/area/result")
	String result(Integer areaId, Model model) {
		Area area = areaRepository.getReferenceById(areaId);
		model.addAttribute("areaName", area.getAreaName());
		List<FruitsArea> fruitArea = repository.findByAreaIdAreaIdOrderByFruitIdAsc(areaId);
		model.addAttribute("fruits", fruitArea);
		return "practice06/02/fruits_list";

	}
}
