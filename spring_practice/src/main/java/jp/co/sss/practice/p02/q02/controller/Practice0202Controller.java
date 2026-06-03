package jp.co.sss.practice.p02.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Practice0202Controller {
	@RequestMapping("/show/redirect_page")
	String redirect() {
		return "practice02/02/redirect_link";
	}

	@RequestMapping("/absolute")
	String google() {
		return "redirect:https://www.google.co.jp";
	}

	@RequestMapping("/relative")
	String relative() {
		return "redirect:/result";
	}

	@RequestMapping("/result")
	String result() {
		return "practice02/02/redirect_result";
	}
}
