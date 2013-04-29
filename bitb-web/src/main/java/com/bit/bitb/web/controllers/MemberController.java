package com.bit.bitb.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.bitb.biz.service.TradeService;

@RequestMapping("/member")
@Controller
public class MemberController {
	@Autowired
	private TradeService tradeService;

	@RequestMapping("/login")
	public void index() {
		//tradeService.buy("3", "30"); error
		System.out.println("/member/login");
	}
}
