package jp.co.sss.practice.p11.q03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Practice1103Controller {

	@RequestMapping("/layout/first")
	String first() {
		return "practice11/03/first";
	}

	@RequestMapping("/layout/second")
	String socond() {
		return "practice11/03/second";
	}

	@RequestMapping("/layout/third")
	String third() {
		return "practice11/03/third";
	}
}
