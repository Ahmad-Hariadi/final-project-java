import http from "@/http-common";

class kartuService {
  insert(data) {
    return http.post("kartuKeluarga/insertKartuKeluarga", data);
  }
  getAll() {
    return http.get("kartuKeluarga/getAllKartuKeluarga");
  }
  deleteKK(id) {
    return http.delete(`kartuKeluarga/deleteKartuKeluarga/${id}`);
  }

  updateKK(id, data) {
    return http.put(`kartuKeluarga/updateKartuKeluarga/${id}`, data);
  }

  updateId(id) {
    return http.get(`kartuKeluarga/updateId/${id}`);
  }
}

export default new kartuService();
