package id.kodehive.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import id.kodehive.springmvc.model.MahasiswaModel;
import id.kodehive.springmvc.service.MahasiswaService;

@Controller
public class MahasiswaController {
	
	@Autowired
	private MahasiswaService mahasiswaService;

	@RequestMapping("/mahasiswa")
	public String home() {
		String html = "/mahasiswa/home";
		return html;
	}
	
	@RequestMapping("/mahasiswa/add")
	public String addMahasiswa() {
		String html = "/mahasiswa/add";
		return html;
	}
	
	@RequestMapping("/mahasiswa/create")
	public String create(HttpServletRequest request) {
		String kodeMahasiswa = request.getParameter("kodeMahasiswa");
		String namaMahasiswa = request.getParameter("namaMahasiswa");
		String alamat = request.getParameter("alamat");
		String jenisKelamin = request.getParameter("jk");
		String status = request.getParameter("status");
		
		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel.setAlamat(alamat);
		mahasiswaModel.setJk(jenisKelamin);
		mahasiswaModel.setKd_mhs(kodeMahasiswa);
		mahasiswaModel.setNm_mhs(namaMahasiswa);
		mahasiswaModel.setStatus(status);
		
		mahasiswaService.saveMahasiswa(mahasiswaModel);
		
		String home = "/mahasiswa/home";
		return home;
	}
}
