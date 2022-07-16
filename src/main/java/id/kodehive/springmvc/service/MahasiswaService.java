package id.kodehive.springmvc.service;

import java.util.List;

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
	
	public void updateMahasiswa(MahasiswaModel mahasiswaModel) {
		mahasiswaRepository.save(mahasiswaModel);
	}
	
	public void deleteMahasiswa(MahasiswaModel mahasiswaModel) {
		mahasiswaRepository.delete(mahasiswaModel);
	}
	
	public MahasiswaModel cariPrimaryKey(String kdMhs) {
		return mahasiswaRepository.cariKodeMhs(kdMhs);
	}
	
	public List<MahasiswaModel> bacaData() {
		return mahasiswaRepository.findAllOrderByNamaMahasiswa();
	}
	
}
