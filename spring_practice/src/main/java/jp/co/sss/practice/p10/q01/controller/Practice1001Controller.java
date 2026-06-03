package jp.co.sss.practice.p10.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Practice1001Controller {

	@RequestMapping("/filter/def")
	String def() {
		return "practice10/01/filter_view";
	}

	@RequestMapping("/filter/xyz")
	String xyz() {
		return "practice10/01/filter_redirect";
	}
}
