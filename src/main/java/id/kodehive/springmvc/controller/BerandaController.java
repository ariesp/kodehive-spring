package id.kodehive.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BerandaController {
	
	@RequestMapping("/beranda")
	public String beranda() {
		String html = "beranda";
		return html;
	}
	
	@RequestMapping("/login/action")
	public String tujuan(HttpServletRequest request, Model model) {
		String mintaUser = request.getParameter("username");
		
		model.addAttribute("userLempar", mintaUser);
		
		String home = "beranda";
		return home;
	}
	
}
