package com.example.ktpApp.service;

import java.util.List;

import com.example.ktpApp.model.AnggotaKeluarga;

public interface IAnggotaKeluargaService {
	public AnggotaKeluarga insertAnggotaKeluarga(AnggotaKeluarga anggotaKeluarga);
	public List<AnggotaKeluarga> getAllAnggotaKeluarga();
	public AnggotaKeluarga updateAnggotaKeluarga(int id, AnggotaKeluarga anggotaKeluarga);
	public AnggotaKeluarga deleteAnggotaKeluarga(int id);
	public AnggotaKeluarga getAnggotaId(int id);
	public List<AnggotaKeluarga> getAnggotaIdKK(String id_kk);
	public List<AnggotaKeluarga> deleteAllAnggota(String id_kk);
}
