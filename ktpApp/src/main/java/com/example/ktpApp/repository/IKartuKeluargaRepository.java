package com.example.ktpApp.repository;

import java.util.List;

import com.example.ktpApp.model.KartuKeluarga;

public interface IKartuKeluargaRepository {

	public KartuKeluarga insertKartuKeluarga(KartuKeluarga kartuKeluarga);
	public List<KartuKeluarga> getAllKartuKeluarga();
	public KartuKeluarga updateKartuKeluarga(int id, KartuKeluarga kartuKeluarga);
	public KartuKeluarga deleteKartuKeluarga(int id);
	public KartuKeluarga updateId(int id);
}
