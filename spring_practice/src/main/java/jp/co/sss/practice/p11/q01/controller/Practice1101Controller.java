package jp.co.sss.practice.p11.q01.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Practice1101Controller {

	@RequestMapping("/fortune")
	String fortune(Model model) {
		int ans;
		ans = (int) ((Math.random() * 4) + 1);
		System.out.println(ans);
		model.addAttribute("ans", ans);
		LocalDate today = LocalDate.now();
		model.addAttribute("today", today);
		return "practice11/01/fortune";
	}

}
