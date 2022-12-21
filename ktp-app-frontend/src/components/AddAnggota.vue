<template>
  <div id="wrapper" class="toggled">
    <div id="page-content-wrapper">
      <div class="container-fluid">
        <h2>
          <strong>{{ titleValue }} Anggota Keluarga</strong>
        </h2>
        <div class="mt-5">
          <router-link
            :to="{ name: 'listAnggota' }"
            v-show="titleValue == 'Detail'"
            class="btn text-light"
            style="background: rgb(2, 1, 41)"
          >
            <b-icon-arrow-left></b-icon-arrow-left> Back
          </router-link>
          <button
            @click="btnBack"
            v-show="titleValue != 'Detail'"
            class="btn text-light"
            style="background: rgb(2, 1, 41)"
          >
            <b-icon-arrow-left></b-icon-arrow-left> Back
          </button>
          <button
            class="btn btn-success ml-2"
            v-show="!btnUp && titleValue != 'Tambah'"
            @click="updateToggle"
          >
            <b-icon-pencil></b-icon-pencil> Update Anggota
          </button>
        </div>
        <div class="mt-5 p-5 border border-primary rounded">
          <form @submit.prevent="insertAnggota">
            <div class="form-row">
              <div class="form-group col-md-6">
                <label>NIK</label>
                <input
                  :disabled="!readOnly"
                  v-model="anggotaData.nik"
                  type="text"
                  class="form-control"
                  :class="{
                    'is-invalid': submitted && $v.anggotaData.nik.$error,
                  }"
                  placeholder="NIK"
                />
                <div
                  v-if="submitted && !$v.anggotaData.nik.required"
                  class="invalid-feedback"
                >
                  NIK tidak boleh kosong!
                </div>
              </div>
              <div class="form-group col-md-6">
                <label>Tanggal Lahir</label>
                <input
                  :disabled="!readOnly"
                  v-model="anggotaData.tanggal_lahir"
                  type="date"
                  class="form-control"
                  :class="{
                    'is-invalid':
                      submitted && $v.anggotaData.tanggal_lahir.$error,
                  }"
                />
                <div
                  v-if="submitted && !$v.anggotaData.tanggal_lahir.required"
                  class="invalid-feedback"
                >
                  Tanggal Lahir tidak boleh kosong!
                </div>
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-6">
                <label>Nama</label>
                <input
                  :disabled="!readOnly"
                  v-model="anggotaData.nama"
                  type="text"
                  class="form-control"
                  :class="{
                    'is-invalid': submitted && $v.anggotaData.nama.$error,
                  }"
                  placeholder="Nama Lengkap"
                />
                <div
                  v-if="submitted && !$v.anggotaData.nama.required"
                  class="invalid-feedback"
                >
                  Nama tidak boleh kosong!
                </div>
              </div>
              <div class="form-group col-md-6">
                <label>Agama</label>
                <input
                  :disabled="!readOnly"
                  v-model="anggotaData.agama"
                  type="text"
                  class="form-control"
                  :class="{
                    'is-invalid': submitted && $v.anggotaData.agama.$error,
                  }"
                  placeholder="Agama"
                />
                <div
                  v-if="submitted && !$v.anggotaData.agama.required"
                  class="invalid-feedback"
                >
                  Agama tidak boleh kosong!
                </div>
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-6">
                <label>Jenis Kelamin</label>
                <select
                  :disabled="!readOnly"
                  v-model="anggotaData.jenis_kelamin"
                  class="form-control"
                  :class="{
                    'is-invalid':
                      submitted && $v.anggotaData.jenis_kelamin.$error,
                  }"
                >
                  <option>Pria</option>
                  <option>Wanita</option>
                </select>
                <div
                  v-if="submitted && !$v.anggotaData.jenis_kelamin.required"
                  class="invalid-feedback"
                >
                  Jenis kelamin tidak boleh kosong!
                </div>
              </div>
              <div class="form-group col-md-6">
                <label>Pendidikan</label>
                <input
                  :disabled="!readOnly"
                  v-model="anggotaData.pendidikan"
                  type="text"
                  class="form-control"
                  :class="{
                    'is-invalid': submitted && $v.anggotaData.pendidikan.$error,
                  }"
                  placeholder="Pendidikan Terakhir"
                />
                <div
                  v-if="submitted && !$v.anggotaData.pendidikan.required"
                  class="invalid-feedback"
                >
                  Pendidikan tidak boleh kosong!
                </div>
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-6">
                <label>Tempat Lahir</label>
                <input
                  :disabled="!readOnly"
                  v-model="anggotaData.tempat_lahir"
                  type="text"
                  class="form-control"
                  :class="{
                    'is-invalid':
                      submitted && $v.anggotaData.tempat_lahir.$error,
                  }"
                  placeholder="Tempat Lahir"
                />
                <div
                  v-if="submitted && !$v.anggotaData.tempat_lahir.required"
                  class="invalid-feedback"
                >
                  Tempat Lahir tidak boleh kosong!
                </div>
              </div>
              <div class="form-group col-md-6">
                <label>Kepala Keluarga</label>
                <select
                  :disabled="!readOnly"
                  v-model="anggotaData.kepala_keluarga"
                  class="form-control"
                  :class="{
                    'is-invalid':
                      submitted && $v.anggotaData.kepala_keluarga.$error,
                  }"
                >
                  <option>Yes</option>
                  <option>No</option>
                </select>
                <div
                  v-if="submitted && !$v.anggotaData.kepala_keluarga.required"
                  class="invalid-feedback"
                >
                  Kepala keluarga tidak boleh kosong!
                </div>
              </div>
            </div>
            <div class="mt-3">
              <button
                v-show="btnUpdate"
                @click="btnCancel"
                type="button"
                class="btn btn-danger mr-2"
              >
                <b-icon-x></b-icon-x> Cancel
              </button>
              <button v-show="btnUpdate" type="submit" class="btn btn-success">
                <b-icon-check2></b-icon-check2> {{ buttonValue }}
              </button>
              <button
                v-show="titleValue == 'Tambah'"
                type="submit"
                class="btn text-light"
                style="background: rgb(2, 1, 41)"
              >
                <b-icon-check2></b-icon-check2> {{ buttonValue }}
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import anggotaService from "@/service/anggotaService";
import Swal from "sweetalert2";
import { required } from "vuelidate/lib/validators";

export default {
  name: "AddAnggotaComponent",
  data() {
    return {
      anggotaData: {
        agama: "",
        id_kk: this.$route.params.id,
        jenis_kelamin: "",
        kepala_keluarga: "",
        nama: "",
        nik: "",
        pendidikan: "",
        tanggal_lahir: "",
        tempat_lahir: "",
      },
      buttonValue: "Submit",
      titleValue: "Tambah",
      btnUpdate: false,
      readOnly: false,
      submitted: false,
      btnUp: false,
    };
  },
  validations: {
    anggotaData: {
      agama: { required },
      jenis_kelamin: { required },
      kepala_keluarga: { required },
      nama: { required },
      nik: { required },
      pendidikan: { required },
      tanggal_lahir: { required },
      tempat_lahir: { required },
    },
  },
  methods: {
    // btnBack() {
    //   if (this.titleValue === "Tambah") {
    //     location.reload();
    //   } else {
    //     this.$route.push({ name: "listAnggota" });
    //   }
    // },
    btnBack() {
      location.reload();
    },
    btnCancel() {
      location.reload();
    },

    insertAnggota() {
      this.submitted = true;
      this.$v.$touch();
      if (this.$v.$invalid) {
        return;
      }

      let data = this.anggotaData;

      if (this.buttonValue === "Submit") {
        anggotaService
          .insert(data)
          .then((response) => {
            console.log(response.data);
            Swal.fire(
              "Sukses!",
              "Data Anggota Berhasil Ditambahkan!",
              "success"
            ).then(() => {
              location.reload();
            });
          })
          .catch((e) => {
            console.log(e);
            Swal.mixin({
              toast: true,
              position: "top",
              iconColor: "white",
              customClass: {
                popup: "colored-toast",
              },
              showConfirmButton: false,
              timer: 3500,
              timerProgressBar: true,
            }).fire({
              icon: "error",
              title: "NIK sudah terdaftar!",
            });
          });
      } else {
        anggotaService
          .updateAnggota(data.id, data)
          .then((response) => {
            this.anggotaData = response.data;
            console.log(this.anggotaData);
            Swal.fire(
              "Sukses!",
              "Data Anggota Berhasil Diupdate!",
              "success"
            ).then(() => {
              location.reload();
            });
          })
          .catch((e) => {
            console.log(e);
            Swal.mixin({
              toast: true,
              position: "top",
              iconColor: "white",
              customClass: {
                popup: "colored-toast",
              },
              showConfirmButton: false,
              timer: 3500,
              timerProgressBar: true,
            }).fire({
              icon: "error",
              title: "NIK sudah terdaftar!",
            });
          });
      }
    },
    getAnggotaId(id) {
      // let id = this.$route.params.id;

      anggotaService
        .getAnggotaId(id)
        .then((response) => {
          this.anggotaData = response.data;
          console.log(this.anggotaData);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    updateToggle() {
      this.btnUpdate = true;
      this.readOnly = true;
      this.btnUp = true;
    },
  },
  props: ["detailAnggotaProps"],
  watch: {
    detailAnggotaProps(newValue) {
      this.anggotaData = newValue;
    },
  },
  mounted() {
    if (this.$route.name == "detailAnggota") {
      this.getAnggotaId(this.$route.params.ide);
      this.buttonValue = "Update";
      this.titleValue = "Detail";
    } else {
      this.readOnly = true;
    }
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
