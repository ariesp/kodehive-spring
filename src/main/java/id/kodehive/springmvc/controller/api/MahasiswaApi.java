package id.kodehive.springmvc.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import id.kodehive.springmvc.model.MahasiswaModel;
import id.kodehive.springmvc.service.MahasiswaService;

@RestController
public class MahasiswaApi {
	
	@Autowired
	private MahasiswaService mahasiswaService;

	@GetMapping("/api/mahasiswa/get")
	@ResponseStatus(code = HttpStatus.OK)
	public List<MahasiswaModel> get() {
		List<MahasiswaModel> mahasiswaModelList = new ArrayList<>();
		mahasiswaModelList = mahasiswaService.bacaData();
		return mahasiswaModelList;
	}
	
	@PostMapping("/api/mahasiswa/post")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Map<String, Object> post(@RequestBody MahasiswaModel mahasiswaModel) {
		mahasiswaService.saveMahasiswa(mahasiswaModel);
		
		Map<String, Object> map = new HashMap<>();
		map.put("Pesan", "Data berhasil disimpan");
		map.put("succcess", Boolean.TRUE);
		
		return map;
	}
	
	@PutMapping("/api/mahasiswa/put")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Map<String, Object> put(@RequestBody MahasiswaModel mahasiswaModel) {
		mahasiswaService.updateMahasiswa(mahasiswaModel);
		
		Map<String, Object> map = new HashMap<>();
		map.put("Pesan", "Data berhasil diubah");
		map.put("succcess", Boolean.TRUE);
		
		return map;
	}
	
	@DeleteMapping("/api/mahasiswa/delete/{kd_mhs}")
	@ResponseStatus(code = HttpStatus.GONE)
	public Map<String, Object> delete(@PathVariable String kd_mhs) {
		mahasiswaService.deleteMahasiswa(mahasiswaService.cariPrimaryKey(kd_mhs));
		
		Map<String, Object> map = new HashMap<>();
		map.put("Pesan", "Data berhasil dihapus");
		map.put("succcess", Boolean.TRUE);
		
		return map;
	}
}
