package jp.co.sss.practice.p11.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Practice1102Controller {

	@RequestMapping("/checkbox/input")
	String input() {

		return "practice11/02/checkbox_input";

	}

	@RequestMapping(path = "/checkbox/result", method = RequestMethod.POST)
	String resul(Model model, String[] destPrefs) {

		if (destPrefs == null) {
			destPrefs = new String[0];
		}
		model.addAttribute("input", destPrefs);
		return "practice11/02/result";
	}

}
