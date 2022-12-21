<template>
  <div id="wrapper" class="toggled">
    <!-- Sidebar -->
    <div id="sidebar-wrapper" class="rounded">
      <ul class="sidebar-nav">
        <li class="sidebar-brand mt-4">
          <h3 class="mt-2">
            <strong>
              <img src="@/assets/img/ktp.png" alt="logo" width="40px" />
              E-KTP APP</strong
            >
          </h3>
          <hr class="bg-light mx-3" />
        </li>
        <li class="mt-2">
          <router-link to="/home" style="color: #fff; background: blue"
            ><b-icon-house-door></b-icon-house-door> Home</router-link
          >
        </li>
        <li class="mt-2">
          <router-link to="/addKK"
            ><b-icon-file-earmark-plus></b-icon-file-earmark-plus> Tambah
            KK</router-link
          >
        </li>
        <li class="mt-4">
          <a @click.prevent="logOut"><b-icon-power></b-icon-power> Sign Out</a>
        </li>
      </ul>
    </div>
    <!-- /#sidebar-wrapper -->
  </div>
</template>

<script>
export default {
  name: "SidebarHomeComponent",
  methods: {
    logOut() {
      localStorage.clear();
      this.$router.push("/");
    },
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

#sidebar-wrapper {
  z-index: 1000;
  position: fixed;
  left: 250px;
  width: 0;
  height: 100%;
  margin-left: -250px;
  overflow-y: auto;
  background: rgb(2, 1, 41);
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  transition: all 0.5s ease;
}

#wrapper.toggled #sidebar-wrapper {
  width: 250px;
}
/* Sidebar Styles */

.sidebar-nav {
  position: absolute;
  top: 0;
  width: 250px;
  margin: 0;
  padding: 0;
  list-style: none;
}

.sidebar-nav li {
  text-indent: 20px;
  line-height: 40px;
}

.sidebar-nav li a {
  display: block;
  text-decoration: none;
  color: #d7d0d0;
}

.sidebar-nav li a:hover {
  text-decoration: none;
  color: #fff;
  background: blue;
}

.sidebar-nav li a:active,
.sidebar-nav li a:focus {
  text-decoration: none;
}

.sidebar-nav > .sidebar-brand {
  height: 65px;
  font-size: 18px;
  line-height: 60px;
}

.sidebar-nav > .sidebar-brand h3 {
  color: #d7d0d0;
}

.sidebar-nav > .sidebar-brand h3:hover {
  color: rgb(255, 255, 255);
  background: none;
}

@media (min-width: 768px) {
  #wrapper {
    padding-left: 0;
  }
  #wrapper.toggled {
    padding-left: 250px;
  }
  #sidebar-wrapper {
    width: 0;
  }
  #wrapper.toggled #sidebar-wrapper {
    width: 250px;
  }
}
</style>
