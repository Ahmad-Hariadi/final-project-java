<template>
  <div>
    <SidebarHome></SidebarHome>
    <Add :detailKartuProps="kartuData"></Add>
    <TableKK v-show="none" @detailEmit="detailFunc"></TableKK>
  </div>
</template>

<script>
import SidebarHome from "@/components/SidebarHome.vue";
import Add from "@/components/Add.vue";
import TableKK from "@/components/TableKK.vue";
// import kartuService from "@/service/kartuService";

export default {
  name: "DetailPage",
  components: {
    SidebarHome,
    Add,
    TableKK,
  },
  data() {
    return {
      kartuData: null,
    };
  },
  methods: {
    detailFunc(item) {
      this.kartuData = item;
    },
    // getId() {
    //   let id = this.$route.params.id;

    //   kartuService
    //     .updateId(id)
    //     .then((response) => {
    //       this.kartuData = response.data;
    //       console.log(this.kartuData);
    //     })
    //     .catch((e) => {
    //       console.log(e);
    //     });
    // },
  },
  // mounted() {
  //   this.getId();
  // },
};
</script>

<style></style>
