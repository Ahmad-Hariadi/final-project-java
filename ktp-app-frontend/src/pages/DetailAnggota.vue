<template>
  <div>
    <SidebarHome></SidebarHome>
    <AddAnggota :detailAnggotaProps="anggotaData"></AddAnggota>
    <TableAnggota v-show="none" @detailEmit="detailFunc"></TableAnggota>
  </div>
</template>

<script>
import SidebarHome from "@/components/SidebarHome.vue";
import TableAnggota from "@/components/TableAnggota.vue";
import AddAnggota from "@/components/AddAnggota.vue";

export default {
  name: "DetailAnggotaPage",
  components: {
    SidebarHome,
    TableAnggota,
    AddAnggota,
  },
  data() {
    return {
      anggotaData: null,
    };
  },
  methods: {
    detailFunc(item) {
      this.anggotaData = item;
    },
  },
};
</script>

<style></style>
