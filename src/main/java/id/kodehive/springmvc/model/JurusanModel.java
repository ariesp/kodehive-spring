package id.kodehive.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_JURUSAN")
public class JurusanModel {

	@Id
	@Column(name = "KD_JURUSAN")
	private String kodeJurusan;
	
	@Column(name = "NAMA_JURUSAN")
	private String namaJurusan;

	public String getKodeJurusan() {
		return kodeJurusan;
	}

	public void setKodeJurusan(String kodeJurusan) {
		this.kodeJurusan = kodeJurusan;
	}

	public String getNamaJurusan() {
		return namaJurusan;
	}

	public void setNamaJurusan(String namaJurusan) {
		this.namaJurusan = namaJurusan;
	}
	
}
