package com.example.ktpApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ktpApp.model.AnggotaKeluarga;
import com.example.ktpApp.repository.IAnggotaKeluargaRepository;
import com.example.ktpApp.service.IAnggotaKeluargaService;

@Service
public class AnggotaKeluargaService implements IAnggotaKeluargaService{
	
	@Autowired
	IAnggotaKeluargaRepository anggotaKeluargaRepository;

	@Override
	public AnggotaKeluarga insertAnggotaKeluarga(AnggotaKeluarga anggotaKeluarga) {
		// TODO Auto-generated method stub
		return anggotaKeluargaRepository.insertAnggotaKeluarga(anggotaKeluarga);
	}

	@Override
	public List<AnggotaKeluarga> getAllAnggotaKeluarga() {
		// TODO Auto-generated method stub
		return anggotaKeluargaRepository.getAllAnggotaKeluarga();
	}

	@Override
	public AnggotaKeluarga updateAnggotaKeluarga(int id, AnggotaKeluarga anggotaKeluarga) {
		// TODO Auto-generated method stub
		return anggotaKeluargaRepository.updateAnggotaKeluarga(id, anggotaKeluarga);
	}

	@Override
	public AnggotaKeluarga deleteAnggotaKeluarga(int id) {
		// TODO Auto-generated method stub
		return anggotaKeluargaRepository.deleteAnggotaKeluarga(id);
	}

	@Override
	public AnggotaKeluarga getAnggotaId(int id) {
		// TODO Auto-generated method stub
		return anggotaKeluargaRepository.getAnggotaId(id);
	}

	@Override
	public List<AnggotaKeluarga> getAnggotaIdKK(String id_kk) {
		// TODO Auto-generated method stub
		return anggotaKeluargaRepository.getAnggotaIdKK(id_kk);
	}

	@Override
	public List<AnggotaKeluarga> deleteAllAnggota(String id_kk) {
		// TODO Auto-generated method stub
		return anggotaKeluargaRepository.deleteAllAnggota(id_kk);
	}

}
