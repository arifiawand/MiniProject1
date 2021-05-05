package com.kodehive.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodehive.model.JurusanModel;
import com.kodehive.repository.JurusanRepository;

@Service
@Transactional
public class JurusanService {

	@Autowired
	JurusanRepository jurusanRepository;

	public void saveJurusan(JurusanModel jurusanModel) {
		jurusanRepository.save(jurusanModel);
	}

	public void update(JurusanModel jurusanModel) {
		jurusanRepository.save(jurusanModel);
	}


	public void delete(JurusanModel jurusanModel) {
		jurusanRepository.delete(jurusanModel);
	}
	
	public List<JurusanModel> readJurusan() {
		return jurusanRepository.findAll();
	}
	
	
}
