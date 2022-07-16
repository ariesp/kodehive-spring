package id.kodehive.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.kodehive.springmvc.model.JurusanModel;

public interface JurusanRepository extends JpaRepository<JurusanModel, String> {

	@Query("SELECT K FROM JurusanModel K WHERE K.kodeJurusan = ?1")
	JurusanModel cariKodeJurusan(String kodeJurusan);
}
