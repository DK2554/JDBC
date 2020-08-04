package com.controller;

import com.service.MemberService;

public class MemberController {
	private MemberService service =  new MemberService();
	
	public void searchMemberAll() {
		service.searchMemberAll();
		
		
	}

}
