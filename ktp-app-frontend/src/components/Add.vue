<template>
  <div id="wrapper" class="toggled">
    <div id="page-content-wrapper">
      <div class="container-fluid">
        <h2>
          <strong>{{ titleValue }} Kartu Keluarga</strong>
        </h2>
        <div class="mt-5">
          <router-link
            to="/home"
            class="btn text-light"
            style="background: rgb(2, 1, 41)"
            ><b-icon-arrow-left></b-icon-arrow-left> Back</router-link
          >
          <button
            v-show="btnUpdate"
            @click="updateToggle"
            class="btn btn-success ml-2"
          >
            <b-icon-pencil></b-icon-pencil> Update Kartu Keluarga
          </button>
          <router-link
            :to="{ name: 'listAnggota' }"
            v-show="titleValue != 'Tambah'"
            class="btn btn-primary ml-2"
          >
            <b-icon-eye></b-icon-eye> Lihat Anggota Keluarga
          </router-link>
        </div>
        <div class="mt-5 p-5 border border-primary rounded">
          <form @submit.prevent="insertKartu">
            <div class="form-row">
              <div class="form-group col-md-6">
                <label>Nomor Kartu Keluarga</label>
                <input
                  v-model="kartuData.nomor_kk"
                  :disabled="!readOnly"
                  type="text"
                  class="form-control"
                  :class="{
                    'is-invalid': submitted && $v.kartuData.nomor_kk.$error,
                  }"
                  placeholder="Nomor Kartu Keluarga"
                />
                <div
                  v-if="submitted && !$v.kartuData.nomor_kk.required"
                  class="invalid-feedback"
                >
                  Nomor kartu keluarga tidak boleh kosong!
                </div>
              </div>
              <div class="form-group col-md-6">
                <label>Desa / Kelurahan</label>
                <input
                  v-model="kartuData.desa_kelurahan"
                  :disabled="!readOnly"
                  type="text"
                  class="form-control"
                  :class="{
                    'is-invalid':
                      submitted && $v.kartuData.desa_kelurahan.$error,
                  }"
                  placeholder="Desa / Kelurahan"
                />
                <div
                  v-if="submitted && !$v.kartuData.desa_kelurahan.required"
                  class="invalid-feedback"
                >
                  Desa / kelurahan tidak boleh kosong!
                </div>
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-6">
                <label>Alamat</label>
                <textarea
                  v-model="kartuData.alamat"
                  :disabled="!readOnly"
                  class="form-control"
                  :class="{
                    'is-invalid': submitted && $v.kartuData.alamat.$error,
                  }"
                  rows="5"
                  placeholder="Alamat"
                />
                <div
                  v-if="submitted && !$v.kartuData.alamat.required"
                  class="invalid-feedback"
                >
                  Alamat tidak boleh kosong!
                </div>
              </div>
              <div class="form-group col-md-6">
                <label>Kecamatan</label>
                <input
                  v-model="kartuData.kecamatan"
                  :disabled="!readOnly"
                  type="text"
                  class="form-control"
                  :class="{
                    'is-invalid': submitted && $v.kartuData.kecamatan.$error,
                  }"
                  placeholder="Kecamatan"
                />
                <div
                  v-if="submitted && !$v.kartuData.kecamatan.required"
                  class="invalid-feedback"
                >
                  Kecamatan tidak boleh kosong!
                </div>
                <div class="mt-4">
                  <label>Kabupaten / Kota</label>
                  <input
                    v-model="kartuData.kabupaten_kota"
                    :disabled="!readOnly"
                    type="text"
                    class="form-control"
                    :class="{
                      'is-invalid':
                        submitted && $v.kartuData.kabupaten_kota.$error,
                    }"
                    placeholder="Kabupaten / Kota"
                  />
                  <div
                    v-if="submitted && !$v.kartuData.kabupaten_kota.required"
                    class="invalid-feedback"
                  >
                    Kabupaten / kota tidak boleh kosong!
                  </div>
                </div>
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-6">
                <label>RT</label>
                <input
                  v-model="kartuData.rt"
                  :disabled="!readOnly"
                  type="text"
                  class="form-control"
                  :class="{
                    'is-invalid': submitted && $v.kartuData.rt.$error,
                  }"
                  placeholder="RT"
                />
                <div
                  v-if="submitted && !$v.kartuData.rt.required"
                  class="invalid-feedback"
                >
                  RT tidak boleh kosong!
                </div>
              </div>
              <div class="form-group col-md-6">
                <label>Provinsi</label>
                <input
                  v-model="kartuData.provinsi"
                  :disabled="!readOnly"
                  type="text"
                  class="form-control"
                  :class="{
                    'is-invalid': submitted && $v.kartuData.provinsi.$error,
                  }"
                  placeholder="Provinsi"
                />
                <div
                  v-if="submitted && !$v.kartuData.provinsi.required"
                  class="invalid-feedback"
                >
                  Provinsi tidak boleh kosong!
                </div>
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-6">
                <label>RW</label>
                <input
                  v-model="kartuData.rw"
                  :disabled="!readOnly"
                  type="text"
                  class="form-control"
                  :class="{
                    'is-invalid': submitted && $v.kartuData.rw.$error,
                  }"
                  placeholder="Rw"
                />
                <div
                  v-if="submitted && !$v.kartuData.rw.required"
                  class="invalid-feedback"
                >
                  RW tidak boleh kosong!
                </div>
              </div>
              <div class="form-group col-md-6">
                <label>Kode Pos</label>
                <input
                  v-model="kartuData.kode_pos"
                  :disabled="!readOnly"
                  type="text"
                  class="form-control"
                  :class="{
                    'is-invalid': submitted && $v.kartuData.kode_pos.$error,
                  }"
                  placeholder="Kode Pos"
                />
                <div
                  v-if="submitted && !$v.kartuData.kode_pos.required"
                  class="invalid-feedback"
                >
                  Kode pos tidak boleh kosong!
                </div>
              </div>
            </div>
            <div class="mt-3">
              <button
                v-show="updateShow"
                @click="cancelFunc"
                type="button"
                class="btn btn-danger mr-2"
              >
                <b-icon-x></b-icon-x> Cancel
              </button>
              <button v-show="updateShow" type="submit" class="btn btn-success">
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
import kartuService from "@/service/kartuService";
import Swal from "sweetalert2";
import { required } from "vuelidate/lib/validators";

export default {
  name: "AddComponent",
  data() {
    return {
      kartuData: {
        alamat: null,
        desa_kelurahan: null,
        kabupaten_kota: null,
        kecamatan: null,
        kode_pos: null,
        nomor_kk: null,
        provinsi: null,
        rt: null,
        rw: null,
      },
      buttonValue: "Submit",
      titleValue: "Tambah",
      btnUpdate: false,
      updateShow: false,
      readOnly: false,
      submitted: false,
    };
  },
  validations: {
    kartuData: {
      alamat: { required },
      desa_kelurahan: { required },
      kabupaten_kota: { required },
      kecamatan: { required },
      kode_pos: { required },
      nomor_kk: { required },
      provinsi: { required },
      rt: { required },
      rw: { required },
    },
  },
  methods: {
    insertKartu() {
      this.submitted = true;
      this.$v.$touch();
      if (this.$v.$invalid) {
        return;
      }

      let data = this.kartuData;

      if (this.buttonValue === "Submit") {
        kartuService
          .insert(data)
          .then((response) => {
            console.log(response.data);
            Swal.fire(
              "Sukses!",
              "Data KK Berhasil Ditambahkan!",
              "success"
            ).then(() => {
              this.kartuData = {};
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
              title: "Nomor KK sudah terdaftar!",
            });
          });
      } else {
        kartuService
          .updateKK(data.id, data)
          .then((response) => {
            this.kartuData = response.data;
            console.log(this.kartuData);
            Swal.fire("Sukses!", "Data KK Berhasil Diupdate!", "success").then(
              () => {
                this.$router.push("/home");
              }
            );
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
              title: "Nomor KK sudah terdaftar!",
            });
          });
      }
    },
    updateToggle() {
      this.btnUpdate = false;
      this.updateShow = true;
      this.readOnly = true;
    },
    cancelFunc() {
      location.reload();
    },
    getId() {
      let id = this.$route.params.id;

      kartuService
        .updateId(id)
        .then((response) => {
          this.kartuData = response.data;
          console.log(this.kartuData);
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
  props: ["detailKartuProps"],
  watch: {
    detailKartuProps(newValue) {
      this.kartuData = newValue;
      console.log(this.kartuData);
    },
  },
  mounted() {
    if (this.$route.name == "detailKK") {
      this.getId(this.$route.params.id);
      this.btnUpdate = true;
      this.titleValue = "Detail";
      this.buttonValue = "Update";
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
