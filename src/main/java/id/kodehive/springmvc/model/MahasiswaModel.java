package id.kodehive.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_MAHASISWA")
public class MahasiswaModel {

	@Id
	@Column(name = "KD_MAHASISWA")
	private String kd_mhs;

	@Column(name = "NM_MAHASISWA")
	private String nm_mhs;

	@Column(name = "JK")
	private String jk;

	@Column(name = "ALAMAT")
	private String alamat;

	@Column(name = "STATUS")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "KODE_JURUSAN", nullable = true)
	
	private JurusanModel jurusanModel;

	public String getKd_mhs() {
		return kd_mhs;
	}

	public void setKd_mhs(String kd_mhs) {
		this.kd_mhs = kd_mhs;
	}

	public String getNm_mhs() {
		return nm_mhs;
	}

	public void setNm_mhs(String nm_mhs) {
		this.nm_mhs = nm_mhs;
	}

	public String getJk() {
		return jk;
	}

	public void setJk(String jk) {
		this.jk = jk;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public JurusanModel getJurusanModel() {
		return jurusanModel;
	}

	public void setJurusanModel(JurusanModel jurusanModel) {
		this.jurusanModel = jurusanModel;
	}

}
