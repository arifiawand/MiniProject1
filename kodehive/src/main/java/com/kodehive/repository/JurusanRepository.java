package com.kodehive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodehive.model.JurusanModel;
import com.kodehive.model.MahasiswaModel;


public interface JurusanRepository extends JpaRepository<JurusanModel, String> {

}