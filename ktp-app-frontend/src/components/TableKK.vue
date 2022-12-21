<template>
  <div id="wrapper" class="toggled">
    <div id="page-content-wrapper">
      <div class="container-fluid">
        <h2><strong>Homepage</strong></h2>
        <div class="d-flex mt-4">
          <div class="card mr-4" style="width: 15rem; height: 7rem">
            <div
              class="card-body rounded text-light"
              style="border: 1px solid blue; background: rgb(2, 1, 41)"
            >
              <h6 class="card-title">Jumlah Kartu Keluarga</h6>
              <h3 class="card-text mt-4">
                <strong>{{ kartuData.length }}</strong>
              </h3>
            </div>
          </div>
          <div class="card" style="width: 15rem; height: 7rem">
            <div
              class="card-body rounded text-light"
              style="border: 1px solid blue; background: rgb(2, 1, 41)"
            >
              <h6 class="card-title">Jumlah Seluruh Warga</h6>
              <h3 class="card-text mt-4">
                <strong>{{ anggotaData.length }}</strong>
              </h3>
            </div>
          </div>
        </div>
        <div class="mt-5">
          <h1>
            <center><strong>Data Kartu Keluarga</strong></center>
          </h1>
          <div v-if="kartuData.length"></div>
          <table class="table table-striped mt-4">
            <thead>
              <tr class="text-center">
                <th scope="col">No</th>
                <th scope="col">Nomor KK</th>
                <th scope="col">Alamat</th>
                <th scope="col">Kota</th>
                <th scope="col">Kode Pos</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody v-if="kartuData.length">
              <tr
                class="text-center"
                v-for="(item, index) in kartuData"
                :key="item.id"
              >
                <th>{{ index + 1 }}</th>
                <td>{{ item.nomor_kk }}</td>
                <td>{{ item.alamat }}</td>
                <td>{{ item.kabupaten_kota }}</td>
                <td>{{ item.kode_pos }}</td>
                <td>
                  <router-link
                    :to="'/detailKK/' + item.id"
                    @click="$emit('detailEmit', item)"
                    class="btn text-light"
                    style="background: rgb(2, 1, 41)"
                  >
                    <b-icon-eye></b-icon-eye> Detail
                  </router-link>
                  <button
                    class="btn btn-danger ml-3"
                    @click="deleteKKFunc(item.id)"
                  >
                    <b-icon-trash></b-icon-trash> Delete
                  </button>
                </td>
              </tr>
            </tbody>
            <tbody v-else>
              <tr class="text-center">
                <td colspan="6">
                  <h5>Data tidak tersedia</h5>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import kartuService from "@/service/kartuService";
import anggotaService from "@/service/anggotaService";
import Swal from "sweetalert2";

export default {
  name: "TableKKComponent",
  data() {
    return {
      kartuData: "",
      anggotaData: "",
    };
  },
  methods: {
    getKartu() {
      kartuService
        .getAll()
        .then((response) => {
          this.kartuData = response.data;
          console.log(this.kartuData);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    getAnggota() {
      anggotaService
        .getAll()
        .then((response) => {
          this.anggotaData = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    deleteKKFunc(id) {
      Swal.fire({
        title: "Apakah anda akan menghapus data KK ini beserta anggotanya?",
        showDenyButton: true,
        showCancelButton: false,
        confirmButtonText: "Delete",
        denyButtonText: `Cancel`,
      }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
          kartuService.deleteKK(id).then((response) => {
            anggotaService.deleteAllAnggota(id).then((response) => {
              console.log(response.data);
            });
            console.log(response.data);
            Swal.fire("Sukses!", "Data KK Berhasil Dihapus!", "success").then(
              () => {
                location.reload();
              }
            );
          });
        } else if (result.isDenied) {
          Swal.fire("Hapus dibatalkan!", "", "info");
        }
      });
    },
  },
  mounted() {
    this.getKartu();
    this.getAnggota();
  },
};
</script>

<style scoped>
#wrapper {
  padding-left: 0;
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  transition: all 0.5s ease;
}

#wrapper.toggled {
  padding-left: 250px;
}

#page-content-wrapper {
  width: 100%;
  position: absolute;
  padding: 15px;
}

#wrapper.toggled #page-content-wrapper {
  position: absolute;
  margin-right: -250px;
}

#page-content-wrapper {
  padding: 20px;
  position: relative;
}

#wrapper.toggled #page-content-wrapper {
  position: relative;
  margin-right: 0;
}
</style>
