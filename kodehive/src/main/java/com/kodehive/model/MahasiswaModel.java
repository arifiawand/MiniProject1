package com.kodehive.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mahasiswa")
public class MahasiswaModel {

	// property
	@Id
	@Column(name="kd_mahasiswa")
	private String kode;
	
	@Column(name="nm_mahasiswa")
	private String nama;
	
	@Column(name="jk")
	private String jk;
	
	@Column(name="alamat")
	private String alamat;
	
	@Column(name="stats")
	private String status;
	
	@Column(name="usia")
	private int usia;
	
	@Column(name="semester")
	private int semester;
	
	@Column(name="kd_jurusan")
	private String jurusan;
	
	@ManyToOne()
	@JoinColumn(name="kd_jurusan", nullable=false, insertable=false, updatable=false)
	private JurusanModel jurusanModel;

	public JurusanModel getJurusanModel() {
		return jurusanModel;
	}

	public void setJurusanModel(JurusanModel jurusanModel) {
		this.jurusanModel = jurusanModel;
	}

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
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

	public String getJurusan() {
		return jurusan;
	}

	public void setJurusan(String jurusan) {
		this.jurusan = jurusan;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUsia() {
		return usia;
	}

	public void setUsia(int usia) {
		this.usia = usia;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	//Plain Old Java Object (POJO)
	
	
}
