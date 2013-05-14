package com.bit.bitb.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.bitb.biz.service.DemoService;
import com.bit.bitb.biz.service.TradeService;

@RequestMapping("/member")
@Controller
public class MemberController {
	@Autowired
	private DemoService demoService;

	@RequestMapping("/login")
	public void login(Model m) {
		//tradeService.buy("3", "30"); error
		m.addAttribute("result", "0");
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(@RequestParam("userName") String userName,@RequestParam("pwd") String pwd,Model m){
		if (demoService.validate(userName, pwd)) {
			m.addAttribute("result", "1");
		}else{
			m.addAttribute("result", "-1");
		}
		
		return "member/login";
	}
}
