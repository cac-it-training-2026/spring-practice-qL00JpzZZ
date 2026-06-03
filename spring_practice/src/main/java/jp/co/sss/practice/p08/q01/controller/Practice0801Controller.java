package jp.co.sss.practice.p08.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import jp.co.sss.practice.p08.q01.form.BodyTempForm;

@Controller
public class Practice0801Controller {

	@RequestMapping("/body_temp/input")
	String input(@ModelAttribute BodyTempForm bodyTempForm,
			Model model) {
		model.addAttribute("bodyTempForm", new BodyTempForm());
		return "practice08/01/bt_input";
	}

	@RequestMapping(path = "/body_temp/check", method = RequestMethod.POST)
	String check(@Valid @ModelAttribute BodyTempForm bodyTempForm, BindingResult result) {
		if (result.hasErrors()) {
			return "practice08/01/bt_input";
		}

		// 体温判定
		if (bodyTempForm.getBodyTemp() >= 37.0) {
			return "practice08/01/bt_ng";
		}

		return "practice08/01/bt_ok";

	}
}
