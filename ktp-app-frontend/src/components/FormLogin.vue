<template>
  <section class="vh-100" style="background: rgb(2, 1, 41)">
    <div class="container py-5 h-100">
      <div class="row d-flex align-items-center justify-content-center h-100">
        <div class="col-md-8 col-lg-7 col-xl-6">
          <img
            src="@/assets/img/ktp.png"
            width="900"
            height="700"
            class="img-fluid"
            alt="ktp image"
          />
        </div>
        <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
          <h2 class="mb-4 text-center text-light">Selamat Datang!</h2>
          <form @submit.prevent="loginUser">
            <!-- Email input -->
            <div class="form-outline mb-4">
              <input
                v-model="loginData.email"
                type="email"
                class="form-control form-control-lg"
                placeholder="Email"
              />
            </div>

            <!-- Password input -->
            <div class="form-outline mb-4">
              <input
                v-model="loginData.password"
                type="password"
                class="form-control form-control-lg"
                placeholder="Password"
              />
            </div>

            <!-- <div class="text-light text-center">
              <p v-show="validasi">Email / Password anda salah</p>
            </div> -->

            <!-- Submit button -->
            <button type="submit" class="btn btn-primary btn-lg btn-block">
              Login
            </button>
            <div>
              <hr class="bg-light" />
              <p class="text-light">
                Tidak memiliki akun?
                <a class="link-danger" @click="$emit('formRegister')">
                  daftar disini
                </a>
              </p>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import userService from "@/service/userService";
import Swal from "sweetalert2";

export default {
  name: "FormLoginComponent",
  data() {
    return {
      loginData: {
        email: null,
        password: null,
      },
      validasi: false,
    };
  },
  methods: {
    loginUser() {
      let data = this.loginData;

      userService
        .login(data)
        .then((response) => {
          console.log(response.data);
          localStorage.user_login = JSON.stringify(response.data);
          this.$router.push("/home");
        })
        .catch((e) => {
          console.log(e.message);
          this.validasi = true;
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
            title: "Email / Password Salah!",
          });
        });
    },
  },
};
</script>

<style>
.colored-toast.swal2-icon-success {
  background-color: #a5dc86 !important;
}

.colored-toast.swal2-icon-error {
  background-color: #f27474 !important;
}

.colored-toast.swal2-icon-warning {
  background-color: #f8bb86 !important;
}

.colored-toast.swal2-icon-info {
  background-color: #3fc3ee !important;
}

.colored-toast.swal2-icon-question {
  background-color: #87adbd !important;
}

.colored-toast .swal2-title {
  color: white;
}

.colored-toast .swal2-close {
  color: white;
}

.colored-toast .swal2-html-container {
  color: white;
}
</style>
