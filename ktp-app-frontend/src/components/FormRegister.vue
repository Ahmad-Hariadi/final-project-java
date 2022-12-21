<template>
  <section class="vh-100" style="background: rgb(2, 1, 41)">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-lg-12 col-xl-11">
          <div class="card text-black" style="border-radius: 25px">
            <div class="card-body p-md-5">
              <div class="row justify-content-center">
                <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                  <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">
                    <strong>Daftar</strong>
                  </p>

                  <form class="mx-1 mx-md-4" @submit.prevent="insertUser">
                    <div class="d-flex flex-row align-items-center mb-4">
                      <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                      <div class="form-outline flex-fill mb-0">
                        <label class="form-label">Nama Lengkap</label>
                        <input
                          v-model="userData.nama"
                          type="text"
                          class="form-control"
                          :class="{
                            'is-invalid': submitted && $v.userData.nama.$error,
                          }"
                          placeholder="Nama Lengkap"
                        />
                        <div
                          v-if="submitted && !$v.userData.nama.required"
                          class="invalid-feedback"
                        >
                          Nama tidak boleh kosong!
                        </div>
                      </div>
                    </div>

                    <div class="d-flex flex-row align-items-center mb-4">
                      <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                      <div class="form-outline flex-fill mb-0">
                        <label class="form-label">Email</label>
                        <input
                          v-model="userData.email"
                          type="email"
                          class="form-control"
                          :class="{
                            'is-invalid': submitted && $v.userData.email.$error,
                          }"
                          placeholder="Email"
                        />
                        <div
                          v-if="submitted && $v.userData.email.$error"
                          class="invalid-feedback"
                        >
                          <span v-if="!$v.userData.email.required"
                            >Email tidak boleh kosong!</span
                          >
                          <span v-if="!$v.userData.email.email"
                            >Format Email salah!</span
                          >
                        </div>
                      </div>
                    </div>

                    <div class="d-flex flex-row align-items-center mb-4">
                      <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                      <div class="form-outline flex-fill mb-0">
                        <label class="form-label">Password</label>
                        <input
                          v-model="userData.password"
                          type="password"
                          class="form-control"
                          :class="{
                            'is-invalid':
                              submitted && $v.userData.password.$error,
                          }"
                          placeholder="Password"
                        />
                        <div
                          v-if="submitted && $v.userData.password.$error"
                          class="invalid-feedback"
                        >
                          <span v-if="!$v.userData.password.required"
                            >Password tidak boleh kosong!</span
                          >
                        </div>
                      </div>
                    </div>

                    <div class="d-flex flex-row align-items-center mb-4">
                      <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                      <div class="form-outline flex-fill mb-0">
                        <label class="form-label">Repassword</label>
                        <input
                          v-model="userData.confirmPassword"
                          type="password"
                          class="form-control"
                          :class="{
                            'is-invalid':
                              submitted && $v.userData.confirmPassword.$error,
                          }"
                          placeholder="Repassword"
                        />
                        <div
                          v-if="submitted && $v.userData.confirmPassword.$error"
                          class="invalid-feedback"
                        >
                          <span v-if="!$v.userData.confirmPassword.required"
                            >Repassword tidak boleh kosong!</span
                          >
                          <span
                            v-else-if="
                              !$v.userData.confirmPassword.sameAsPassword
                            "
                            >Password tidak sama!</span
                          >
                        </div>
                      </div>
                    </div>

                    <div
                      class="d-flex justify-content-center mx-4 mb-3 mb-lg-4"
                    >
                      <button
                        type="submit"
                        class="btn btn-danger btn-lg"
                        @click.prevent="gotoLogin"
                      >
                        Login
                      </button>
                      <button type="submit" class="btn btn-primary btn-lg ml-3">
                        Daftar
                      </button>
                    </div>
                  </form>
                </div>
                <div
                  class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2"
                >
                  <lottie-player
                    src="https://assets5.lottiefiles.com/packages/lf20_2jczmi5y.json"
                    background="transparent"
                    speed="1"
                    style="width: 70vw; height: 70vh"
                    loop
                    autoplay
                  ></lottie-player>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import userService from "@/service/userService.js";
import Swal from "sweetalert2";
import { required, email, sameAs } from "vuelidate/lib/validators";

export default {
  name: "FormRegisterComponent",
  data() {
    return {
      userData: {
        nama: "",
        email: "",
        password: "",
        confirmPassword: "",
      },
      submitted: false,
    };
  },
  validations: {
    userData: {
      nama: { required },
      email: { required, email },
      password: { required },
      confirmPassword: { required, sameAsPassword: sameAs("password") },
    },
  },
  methods: {
    clearData() {
      this.userData.nama = "";
      this.userData.email = "";
      this.userData.password = "";
      this.userData.confirmPassword = "";
      this.submitted = false;
    },
    gotoLogin() {
      this.clearData();
      this.$emit("formLogin");
    },
    insertUser() {
      this.submitted = true;
      this.$v.$touch();
      if (this.$v.$invalid) {
        return;
      }

      let data = {
        nama: this.userData.nama,
        email: this.userData.email,
        password: this.userData.password,
      };

      userService
        .insert(data)
        .then((response) => {
          console.log(response.data);
          Swal.fire("Sukses!", "Data Berhasil Terdaftar!", "success").then(
            () => {
              this.gotoLogin();
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
            title: "Email sudah terdaftar!",
          });
        });
    },
  },
};
</script>

<style></style>
