<template>
<div>
  <FormLogin v-show="!viewForm" @formRegister = "daftarClicked"></FormLogin>
  <FormRegister v-show="viewForm" @formLogin = "loginClicked"></FormRegister>
</div>
</template>

<script>
import FormLogin from "@/components/FormLogin.vue"
import FormRegister from "@/components/FormRegister.vue"
export default {
    name: "LoginPage",
    components: {
        FormLogin,
        FormRegister,
    },
    data() {
      return {
        viewForm: false,
        userData: null,
      }
    },
    methods: {
      daftarClicked(item) {
        this.userData = item;
        this.viewForm = true;
      },
      loginClicked(item) {
        this.userData = item,
        this.viewForm = false;
      }
    }

}
</script>

<style>
</style>