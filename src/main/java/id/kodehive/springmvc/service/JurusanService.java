package id.kodehive.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.kodehive.springmvc.model.JurusanModel;
import id.kodehive.springmvc.repository.JurusanRepository;

@Service
public class JurusanService {

	@Autowired
	private JurusanRepository jurusanRepository;
	
	public List<JurusanModel> readJurusan() {
		return jurusanRepository.findAll();
	}
	
	public void saveJurusan(JurusanModel jurusanModel) {
		jurusanRepository.save(jurusanModel);
	}
	
	public JurusanModel cariKodeJurusan(String kodeJurusan) {
		return jurusanRepository.cariKodeJurusan(kodeJurusan);
	}
}
