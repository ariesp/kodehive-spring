package id.kodehive.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.kodehive.springmvc.model.MahasiswaModel;
import id.kodehive.springmvc.repository.MahasiswaRepository;

@Service
public class MahasiswaService {

	@Autowired
	MahasiswaRepository mahasiswaRepository;
	
	public void saveMahasiswa(MahasiswaModel mahasiswaModel) {
		mahasiswaRepository.save(mahasiswaModel);
	}
	
}
