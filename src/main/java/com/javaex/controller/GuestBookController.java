package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestBookController {
	
	@Autowired
	private GuestbookDao guestDao;
	
	//리스트
	@RequestMapping(value="/addList", method= {RequestMethod.GET, RequestMethod.POST}) 
	public String addList(Model model) {
		System.out.println("[GuestBookController.addList]");
		
		//GuestbookDao guestDao = new GuestbookDao();
		List<GuestbookVo> guestList = guestDao.getGuestList();
		
		model.addAttribute("gList", guestList);
	    
		//view
	    return "/WEB-INF/addList.jsp";
	}	
	
	//등록
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(@RequestParam("name") String name,
					  @RequestParam("content") String content,
					  @RequestParam("password") String password) {
		System.out.println("[GuestBookController.add]");

		//GuestbookDao guestDao = new GuestbookDao();
		GuestbookVo guestVo = new GuestbookVo(name, password, content);
		
		guestDao.guestInsert(guestVo);
		
		return "redirect:/addList";
	}
	
	
	

}
