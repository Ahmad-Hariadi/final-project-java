<template>
  <div>
    <SidebarHome></SidebarHome>
    <TableAnggota v-show="!viewForm" @addTable="addList"></TableAnggota>
    <AddAnggota v-show="viewForm"></AddAnggota>
  </div>
</template>

<script>
import SidebarHome from "@/components/SidebarHome.vue";
import TableAnggota from "@/components/TableAnggota.vue";
import AddAnggota from "@/components/AddAnggota.vue";

export default {
  name: "ListAnggotaPage",
  components: {
    SidebarHome,
    TableAnggota,
    AddAnggota,
  },
  data() {
    return {
      anggotaData: null,
      viewForm: false,
    };
  },
  methods: {
    addList(item) {
      this.anggotaData = item;
      this.viewForm = true;
    },
  },
};
</script>

<style></style>
