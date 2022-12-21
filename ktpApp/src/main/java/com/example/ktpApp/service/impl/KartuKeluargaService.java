package com.example.ktpApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ktpApp.model.KartuKeluarga;
import com.example.ktpApp.repository.IKartuKeluargaRepository;
import com.example.ktpApp.service.IKartuKeluargaService;

@Service
public class KartuKeluargaService implements IKartuKeluargaService{

	@Autowired
	IKartuKeluargaRepository kartuKeluargaRepository;
	
	@Override
	public KartuKeluarga insertKartuKeluarga(KartuKeluarga kartuKeluarga) {
		// TODO Auto-generated method stub
		return kartuKeluargaRepository.insertKartuKeluarga(kartuKeluarga);
	}

	@Override
	public List<KartuKeluarga> getAllKartuKeluarga() {
		// TODO Auto-generated method stub
		return kartuKeluargaRepository.getAllKartuKeluarga();
	}

	@Override
	public KartuKeluarga updateKartuKeluarga(int id, KartuKeluarga kartuKeluarga) {
		// TODO Auto-generated method stub
		return kartuKeluargaRepository.updateKartuKeluarga(id, kartuKeluarga);
	}

	@Override
	public KartuKeluarga deleteKartuKeluarga(int id) {
		// TODO Auto-generated method stub
		return kartuKeluargaRepository.deleteKartuKeluarga(id);
	}

	@Override
	public KartuKeluarga updateId(int id) {
		// TODO Auto-generated method stub
		return kartuKeluargaRepository.updateId(id);
	}

}
