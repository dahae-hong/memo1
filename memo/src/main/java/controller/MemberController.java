package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {
	@Autowired
	MemberService memberservice;
	
	@RequestMapping("input")
	public String input() {
		return "/WEB-INF/view/input.jsp";
	}
	
	@RequestMapping("inputProc")
	public ModelAndView inputProc(String id, String password) {
		System.out.println(id+":"+password);
		int result = memberservice.insert(id,password);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result==1 ? "성공":"실패");
		mv.setViewName("/WEB-INF/view/result.jsp");
		return mv;
		
	}
}
