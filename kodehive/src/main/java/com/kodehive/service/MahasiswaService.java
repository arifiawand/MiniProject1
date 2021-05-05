package com.kodehive.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodehive.model.MahasiswaModel;
import com.kodehive.repository.MahasiswaRepository;

@Service
@Transactional
public class MahasiswaService {

	@Autowired
	MahasiswaRepository mahasiswaRepository;

	public void save(MahasiswaModel mahasiswaModel) {
		mahasiswaRepository.save(mahasiswaModel);
	}

	public void update(MahasiswaModel mahasiswaModel) {
		mahasiswaRepository.save(mahasiswaModel);
	}

	public MahasiswaModel cariPrimaryKey(String kode) {
		return mahasiswaRepository.cariKodeMhs(kode);
	}

	public List<MahasiswaModel> cariUsia(String operator, String awalan, int usia) {
		List<MahasiswaModel> mahasiswaModelList = new ArrayList<MahasiswaModel>();
		switch (operator) {
		case "samaDengan":
			mahasiswaModelList = this.mahasiswaRepository.opSamaDengan(awalan, usia);
			break;
		case "lebihDari":
			mahasiswaModelList = this.mahasiswaRepository.opLebihDari(awalan, usia);
			break;
		case "kurangDari":
			mahasiswaModelList = this.mahasiswaRepository.opKurangDari(awalan, usia);
			break;
		case "lebihSama":
			mahasiswaModelList = this.mahasiswaRepository.opLebihSama(awalan, usia);
			break;
		case "kurangSama":
			mahasiswaModelList = this.mahasiswaRepository.opKurangSama(awalan, usia);
			break;
		case "negasi":
			mahasiswaModelList = this.mahasiswaRepository.opNegasi(awalan, usia);
		}
		return mahasiswaModelList;
	}

	public void delete(MahasiswaModel mahasiswaModel) {
		mahasiswaRepository.delete(mahasiswaModel);
	}
	
	public List<MahasiswaModel> readAll() {
		return mahasiswaRepository.findAll();
	}

}
