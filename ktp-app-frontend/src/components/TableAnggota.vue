<template>
  <div id="wrapper" class="toggled">
    <div id="page-content-wrapper">
      <div class="container-fluid">
        <h2><strong>Daftar Anggota Keluarga</strong></h2>

        <div class="mt-5">
          <router-link
            :to="'/detailKK/' + this.$route.params.id"
            class="btn text-light"
            style="background: rgb(2, 1, 41)"
          >
            <b-icon-arrow-left></b-icon-arrow-left> Back
          </router-link>
          <button @click="$emit('addTable')" class="btn btn-primary ml-2">
            <b-icon-file-earmark-plus></b-icon-file-earmark-plus> Tambah Anggota
            Keluarga
          </button>
          <table class="table table-striped mt-4">
            <thead>
              <tr class="text-center">
                <th scope="col">No</th>
                <th scope="col">NIK</th>
                <th scope="col">Nama</th>
                <th scope="col">Jenis Kelamin</th>
                <th scope="col">Kepala Keluarga</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody v-if="anggotaData.length">
              <tr
                v-for="(item, index) in anggotaData"
                :key="item.id"
                class="text-center"
              >
                <th>{{ index + 1 }}</th>
                <td>{{ item.nik }}</td>
                <td>{{ item.nama }}</td>
                <td>{{ item.jenis_kelamin }}</td>
                <td>{{ item.kepala_keluarga }}</td>
                <td>
                  <router-link
                    :to="{ name: 'detailAnggota', params: { ide: item.id } }"
                    @click="$emit('detailEmit', item)"
                    class="btn text-light"
                    style="background: rgb(2, 1, 41)"
                  >
                    <b-icon-eye></b-icon-eye> Detail
                  </router-link>
                  <button
                    @click="deleteAnggota(item.id)"
                    class="btn btn-danger ml-2"
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
import anggotaService from "@/service/anggotaService";
import Swal from "sweetalert2";

export default {
  name: "TableAnggotaComponent",
  data() {
    return {
      anggotaData: "",
    };
  },
  methods: {
    getAnggotaIdKK() {
      let id_kk = this.$route.params.id;

      anggotaService
        .getAnggotaIdKK(id_kk)
        .then((response) => {
          this.anggotaData = response.data;
          console.log(this.anggotaData);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    deleteAnggota(id) {
      Swal.fire({
        title: "Apakah anda yakin akan menghapus data anggota ini?",
        showDenyButton: true,
        showCancelButton: false,
        confirmButtonText: "Delete",
        denyButtonText: `Cancel`,
      }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
          anggotaService.deleteAnggota(id).then((response) => {
            console.log(response.data);
            Swal.fire(
              "Sukses!",
              "Data Anggota Berhasil Dihapus!",
              "success"
            ).then(() => {
              location.reload();
            });
          });
        } else if (result.isDenied) {
          Swal.fire("Hapus dibatalkan!", "", "info");
        }
      });
    },
  },
  mounted() {
    this.getAnggotaIdKK();
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
