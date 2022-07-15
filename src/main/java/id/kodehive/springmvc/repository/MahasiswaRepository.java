package id.kodehive.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.kodehive.springmvc.model.MahasiswaModel;

public interface MahasiswaRepository extends JpaRepository<MahasiswaModel, String> {
	
	@Query("SELECT P FROM MahasiswaModel P WHERE P.kd_mhs = ?1")
	MahasiswaModel cariKodeMhs(String kd_mhs);
	
}
