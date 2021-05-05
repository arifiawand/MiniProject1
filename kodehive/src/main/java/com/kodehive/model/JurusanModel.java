package com.kodehive.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jurusan")
public class JurusanModel {

	// property
	@Id
	@Column(name="kd_jurusan")
	private String kodeJurusan;
	
	@Column(name="nm_jurusan")
	private String namaJurusan;
	
	@Column(name="kd_fakultas")
	private String kodeFakultas;
	

	public String getKodeFakultas() {
		return kodeFakultas;
	}

	public void setKodeFakultas(String kodeFakultas) {
		this.kodeFakultas = kodeFakultas;
	}

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
