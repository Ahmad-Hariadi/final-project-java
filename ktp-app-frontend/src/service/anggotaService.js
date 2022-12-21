import http from "@/http-common";

class anggotaService {
  insert(data) {
    return http.post("/anggotaKeluarga/insertAnggotaKeluarga", data);
  }

  getAll() {
    return http.get("anggotaKeluarga/getAllAnggotaKeluarga");
  }

  deleteAnggota(id) {
    return http.delete(`/anggotaKeluarga/deleteAnggotaKeluarga/${id}`);
  }

  updateAnggota(id, data) {
    return http.put(`/anggotaKeluarga/updateAnggotaKeluarga/${id}`, data);
  }

  getAnggotaId(id) {
    return http.get(`/anggotaKeluarga/getAnggotaId/${id}`);
  }

  getAnggotaIdKK(id_kk) {
    return http.get(`/anggotaKeluarga/getAnggotaIdKK/${id_kk}`);
  }

  deleteAllAnggota(id_kk) {
    return http.delete(`/anggotaKeluarga/deleteAllAnggota/${id_kk}`);
  }
}

export default new anggotaService();
