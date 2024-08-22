package com.code.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping(value="/")
	public ModelAndView test()
	{
		return new ModelAndView("welcome");
	}
}
