package id.kodehive.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import id.kodehive.springmvc.model.JurusanModel;
import id.kodehive.springmvc.model.MahasiswaModel;
import id.kodehive.springmvc.service.JurusanService;
import id.kodehive.springmvc.service.MahasiswaService;

@Controller
public class MahasiswaController {
	
	@Autowired
	private MahasiswaService mahasiswaService;
	
	@Autowired
	private JurusanService jurusanService;

	@RequestMapping("/mahasiswa")
	public String home() {
		String html = "/mahasiswa/home";
		return html;
	}
	
	// untuk ajax yang memanggil view popup
	@RequestMapping("/mahasiswa/add")
	public String addMahasiswa(Model model) {
		String html = "/mahasiswa/add";
		
		bacaJurusan(model);
		
		return html;
	}
	
	// untuk ajax yang memanggil action
	@RequestMapping("/mahasiswa/create")
	public String create(HttpServletRequest request) {
		String kodeMahasiswa = request.getParameter("kodeMahasiswa");
		String namaMahasiswa = request.getParameter("namaMahasiswa");
		String alamat = request.getParameter("alamat");
		String jenisKelamin = request.getParameter("jk");
		String status = request.getParameter("status");
		String kodeJurusan = request.getParameter("jurusan");
		
		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel.setAlamat(alamat);
		mahasiswaModel.setJk(jenisKelamin);
		mahasiswaModel.setKd_mhs(kodeMahasiswa);
		mahasiswaModel.setNm_mhs(namaMahasiswa);
		mahasiswaModel.setStatus(status);
		
		// set data jurusan
		JurusanModel jurusanModel = jurusanService.cariKodeJurusan(kodeJurusan);
		mahasiswaModel.setJurusanModel(jurusanModel);
		
		mahasiswaService.saveMahasiswa(mahasiswaModel);
		
		String home = "/mahasiswa/home";
		return home;
	}
	
	// untuk ajax yang memanggil action
	@RequestMapping("/mahasiswa/update")
	public String update(HttpServletRequest request) {
		String kodeMahasiswa = request.getParameter("kodeMahasiswa");
		String namaMahasiswa = request.getParameter("namaMahasiswa");
		String alamat = request.getParameter("alamat");
		String jenisKelamin = request.getParameter("jk");
		String status = request.getParameter("status");
		String kodeJurusan = request.getParameter("jurusan");
		
		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel.setAlamat(alamat);
		mahasiswaModel.setJk(jenisKelamin);
		mahasiswaModel.setKd_mhs(kodeMahasiswa);
		mahasiswaModel.setNm_mhs(namaMahasiswa);
		mahasiswaModel.setStatus(status);
		
		// set data jurusan
		JurusanModel jurusanModel = jurusanService.cariKodeJurusan(kodeJurusan);
		mahasiswaModel.setJurusanModel(jurusanModel);
		
		mahasiswaService.updateMahasiswa(mahasiswaModel);
		
		String home = "/mahasiswa/home";
		return home;
	}
	
	@RequestMapping("/mahasiswa/list")
	public String bacaData(Model model) {
		List<MahasiswaModel> mahasiswaModelList = new ArrayList<MahasiswaModel>();
		
		mahasiswaModelList = mahasiswaService.bacaData();
		
		model.addAttribute("bingkisanBacaData", mahasiswaModelList);
		
		String html = "/mahasiswa/list";
		return html;
	}
	
	// untuk ajax yang memanggil view popup
	@RequestMapping("/mahasiswa/edit")
	public String edit(HttpServletRequest request, Model model) {
		String kodeMahasiswa = request.getParameter("kd_mhs");
		
		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel = mahasiswaService.cariPrimaryKey(kodeMahasiswa);
		
		model.addAttribute("bingkisanEdit", mahasiswaModel);
		
		bacaJurusan(model);
		
		String html = "/mahasiswa/edit";
		return html;
	}
	
	// untuk ajax yang memanggil view popup
	@RequestMapping("/mahasiswa/remove")
	public String remove(HttpServletRequest request, Model model) {
		String kodeMahasiswa = request.getParameter("kd_mhs");
		
		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel = mahasiswaService.cariPrimaryKey(kodeMahasiswa);
		
		model.addAttribute("bingkisanDelete", mahasiswaModel);
		
		String html = "/mahasiswa/remove";
		return html;
	}
	
	// untuk ajax yang memanggil action
	@RequestMapping("/mahasiswa/delete")
	public String delete(HttpServletRequest request) {
		String kodeMahasiswa = request.getParameter("kodeMahasiswa");
		
		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel = mahasiswaService.cariPrimaryKey(kodeMahasiswa);
		
		mahasiswaService.deleteMahasiswa(mahasiswaModel);
		
		String home = "/mahasiswa/home";
		return home;
	}
	
	@RequestMapping("/mahasiswa/jurusan")
	public void bacaJurusan(Model model) {
		List<JurusanModel> jurusanModelList = new ArrayList<>();
		jurusanModelList = jurusanService.readJurusan();
		
		model.addAttribute("jurusanModelList", jurusanModelList);
	}
	
	
}
