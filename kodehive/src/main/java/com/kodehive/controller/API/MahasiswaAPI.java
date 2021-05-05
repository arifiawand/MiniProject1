package com.kodehive.controller.API;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kodehive.service.JurusanService;
import com.kodehive.service.MahasiswaService;
import com.kodehive.model.MahasiswaModel;
import com.kodehive.model.JurusanModel;
import com.kodehive.repository.MahasiswaRepository;

@RestController
public class MahasiswaAPI {
	@Autowired
	MahasiswaService mahasiswaService;
	@Autowired
	JurusanService jurusanService;
	@Autowired
	MahasiswaRepository mahasiswaRepository;
	
	@GetMapping("/api/mahasiswa/get")
	@ResponseStatus(code = HttpStatus.OK)
	public List<MahasiswaModel> get(){
		List<MahasiswaModel> mahasiswaModelList = new ArrayList<MahasiswaModel>();
		mahasiswaModelList = this.mahasiswaService.readAll();
		return mahasiswaModelList;
	}
	
	@PostMapping("/api/mahasiswa/post")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Map<String , Object> postData(@RequestBody MahasiswaModel mahasiswaModel){
		this.mahasiswaService.save(mahasiswaModel);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("Pesan", Boolean.TRUE);
		map.put("Berhasil", "Data Berhasil diInput");
		
		return map;
	}
	
	@PutMapping("/api/mahasiswa/put")
	public Map<String, Object> putData(@RequestBody MahasiswaModel mahasiswaModel){
this.mahasiswaService.update(mahasiswaModel);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("Pesan", Boolean.TRUE);
		map.put("Berhasil", "Data Berhasil diInput");
		
		return map;
	}
	
	@DeleteMapping("/api/mahasiswa/delete/{kode}")
	@ResponseStatus(code=HttpStatus.GONE)
	public Map<String, Object> deleteApi(@PathVariable String kode){
		
		this.mahasiswaService.delete(this.mahasiswaRepository.cariKodeMhs(kode));
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("Pesan", Boolean.TRUE);
		map.put("Berhasil", "Data Berhasil diHapus");
		
		return map;
	}
}
