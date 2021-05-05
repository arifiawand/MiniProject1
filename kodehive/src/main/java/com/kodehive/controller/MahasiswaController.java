package com.kodehive.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodehive.model.JurusanModel;
import com.kodehive.model.MahasiswaModel;
import com.kodehive.service.JurusanService;
import com.kodehive.service.MahasiswaService;

@Controller
public class MahasiswaController {
@Autowired
MahasiswaService mahasiswaService;
@Autowired
JurusanService jurusanService;

	@RequestMapping("/mahasiswa/home")
	public String home() {
		String html = "mahasiswa/home";
		return html;
	}
	@RequestMapping("/mahasiswa/add")
	public String addMahasiswa(Model model) {
		this.bacaJurusan(model);
		
		String html = "mahasiswa/add";
		return html;
	}
	@RequestMapping("/mahasiswa/cari_usia")
	public String cariUsia() {
		String html = "mahasiswa/cari_usia";
		return html;
	}
	
	
	@RequestMapping("/mahasiswa/create")
	public String create(HttpServletRequest request) {
		String kode = request.getParameter("kode");
		String nama = request.getParameter("nama");
		String alamat = request.getParameter("alamat");
		String jk = request.getParameter("jk");
		String status = request.getParameter("status");
		String usia = request.getParameter("usia");
		String semester = request.getParameter("semester");
		String jurusan = request.getParameter("jurusan");
		
		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel.setKode(kode);
		mahasiswaModel.setNama(nama);
		mahasiswaModel.setJk(jk);
		mahasiswaModel.setAlamat(alamat);
		mahasiswaModel.setStatus(status);
		mahasiswaModel.setUsia(Integer.valueOf(usia));
		mahasiswaModel.setSemester(Integer.valueOf(semester));
		mahasiswaModel.setJurusan(jurusan);

		
		this.mahasiswaService.save(mahasiswaModel);
		
		String html= "/mahasiswa/home";
		return html;
	}
	
	@RequestMapping("/mahasiswa/update")
	public String udpate(HttpServletRequest request) {
		String kode = request.getParameter("kode");
		String nama = request.getParameter("nama");
		String alamat = request.getParameter("alamat");
		String jk = request.getParameter("jk");
		String status = request.getParameter("status");
		String usia = request.getParameter("usia");
		String semester = request.getParameter("semester");
		String jurusan = request.getParameter("jurusan");
		
		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel.setKode(kode);
		mahasiswaModel.setNama(nama);
		mahasiswaModel.setJk(jk);
		mahasiswaModel.setAlamat(alamat);
		mahasiswaModel.setStatus(status);
		mahasiswaModel.setUsia(Integer.valueOf(usia));
		mahasiswaModel.setSemester(Integer.valueOf(semester));
		mahasiswaModel.setJurusan(jurusan);
		
		this.mahasiswaService.update(mahasiswaModel);
		
		String html= "/mahasiswa/home";
		return html;
	}
	
	@RequestMapping("/mahasiswa/list")
	public String readAll(Model model) {
		List<MahasiswaModel> mahasiswaModelList = new ArrayList<MahasiswaModel>();
		mahasiswaModelList = this.mahasiswaService.readAll();
		model.addAttribute("mahasiswaModelList", mahasiswaModelList);
		
		
		String html = "/mahasiswa/list";
		return html;
	}
	
	
	
	@RequestMapping("/mahasiswa/detail")
	public String detail(HttpServletRequest request, Model model) {
		String kode = request.getParameter("kode");
		
		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel = this.mahasiswaService.cariPrimaryKey(kode);
		
		model.addAttribute("detail", mahasiswaModel);
		
		String html = "/mahasiswa/detail";
		return html;
	}
	
	@RequestMapping("/mahasiswa/edit")
	public String edit(HttpServletRequest request, Model model) {
		this.bacaJurusan(model);
		String kode = request.getParameter("kode");
		
		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel = this.mahasiswaService.cariPrimaryKey(kode);
		
		model.addAttribute("valueEdit", mahasiswaModel);
		
		String html = "/mahasiswa/edit";
		return html;
	}
	
	@RequestMapping("/mahasiswa/proses_cari_usia")
	public String cari_usia(HttpServletRequest request, Model model) {
		String operator = request.getParameter("operator");
		String awalan = request.getParameter("awalan");
		int usia = Integer.valueOf(request.getParameter("cariUsia"));
		List<MahasiswaModel> mahasiswaModelList = new ArrayList<MahasiswaModel>();
		mahasiswaModelList = this.mahasiswaService.cariUsia(operator, awalan, usia);
		model.addAttribute("mahasiswaModelList", mahasiswaModelList);
		
		String html = "/mahasiswa/proses_cari_usia";
		return html;
	}
	
	@RequestMapping("/mahasiswa/remove")
	public String remove(HttpServletRequest request, Model model) {
		String kode = request.getParameter("kode");
		
		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel = this.mahasiswaService.cariPrimaryKey(kode);
		
		model.addAttribute("valueDelete", mahasiswaModel);
		
		String html = "/mahasiswa/remove";
		return html;
	}
	
	@RequestMapping("/mahasiswa/delete")
	public String delete(HttpServletRequest request, Model model) {
		String kode = request.getParameter("kode");
		
		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel = this.mahasiswaService.cariPrimaryKey(kode);
		this.mahasiswaService.delete(mahasiswaModel);
		
		String html = "/mahasiswa/home";
		return html;
	}
	
	@RequestMapping("/mahasiswa/jurusan")
	public void bacaJurusan(Model model) {
		List<JurusanModel> jurusanModelList = new ArrayList<>();
		jurusanModelList = this.jurusanService.readJurusan();
		
		model.addAttribute("jurusanModelList", jurusanModelList);
	}
	

}
