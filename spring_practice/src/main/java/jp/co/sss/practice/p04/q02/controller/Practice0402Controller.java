package jp.co.sss.practice.p04.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class Practice0402Controller {

	@RequestMapping(path = "/numguess/start", method = RequestMethod.GET)
	String ans(HttpSession session) {
		Integer hitNumber = (int) ((Math.random() * 9) + 1);
		session.setAttribute("hitNumber", hitNumber);
		System.out.println(hitNumber);
		return "practice04/02/numguess_start";
	}

	@RequestMapping(path = "/numguess/input", method = RequestMethod.GET)
	String input() {
		return "practice04/02/numguess_input";
	}

	@RequestMapping(path = "/numguess/judge", method = RequestMethod.GET)
	String judge(HttpSession session, Integer inputNum) {
		Integer hitNumber = (Integer) session.getAttribute("hitNumber");
		if (inputNum.equals(hitNumber)) {
			return "redirect:/numguess/hit";
		} else {
			return "practice04/02/numguess_judge";
		}
	}

	@RequestMapping(path = "/numguess/hit", method = RequestMethod.GET)
	String hit(Model model, HttpSession session) {
		model.addAttribute("ans", "当たりです！ 正解は" + session.getAttribute("hitNumber") + "でした。");
		session.removeAttribute("hitNumber");
		return "practice04/02/numguess_end";
	}

}
