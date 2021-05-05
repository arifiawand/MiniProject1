package com.kodehive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodehive.model.MahasiswaModel;

public interface MahasiswaRepository extends JpaRepository<MahasiswaModel, String> {

	@Query("Select P from MahasiswaModel P where kd_mahasiswa = ?1")
	MahasiswaModel cariKodeMhs(String kode);
	
	@Query("delete from MahasiswaModel P where kd_mahasiswa = ?1")
	MahasiswaModel delete(String kode);

	@Query("Select P from MahasiswaModel P where nm_mahasiswa LIKE ?1% and usia = ?2")
	List<MahasiswaModel> opSamaDengan(String awalan, int usia);
	
	@Query("Select P from MahasiswaModel P where nm_mahasiswa LIKE ?1% and usia > ?2")
	List<MahasiswaModel> opLebihDari(String awalan, int usia);
	
	@Query("Select P from MahasiswaModel P where nm_mahasiswa LIKE ?1% and usia < ?2")
	List<MahasiswaModel> opKurangDari(String awalan, int usia);
	
	@Query("Select P from MahasiswaModel P where nm_mahasiswa LIKE ?1% and usia >= ?2")
	List<MahasiswaModel> opLebihSama(String awalan, int usia);
	
	@Query("Select P from MahasiswaModel P where nm_mahasiswa LIKE ?1% and usia <= ?2")
	List<MahasiswaModel> opKurangSama(String awalan, int usia);
	
	@Query("Select P from MahasiswaModel P where nm_mahasiswa LIKE ?1% and usia != ?2")
	List<MahasiswaModel> opNegasi(String awalan, int usia);
	
}