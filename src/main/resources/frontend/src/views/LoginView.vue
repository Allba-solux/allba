<template>
  <div class="main">
    <div class="container">
      <form @submit.prevent="submitForm">
        <h1 class="logo">Login</h1>
        <input
          type="text"
          placeholder="ID"
          id="id"
          class="account"
          v-model="pid"
        />
        <input
          type="password"
          placeholder="Password"
          id="password"
          class="account"
          v-model="pwd"
        />
        <button id="login" class="account" type="submit">login</button>
        <div class="register">
          <router-link to="signup"
            ><i class="fa-solid fa-right-from-bracket"></i
            ><span class="regi"> 회원가입</span></router-link
          >
        </div>
        <!-- {{ logMessage }} -->
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      //form values
      //log
      // logMessage: "",
    };
  },
  methods: {
    async submitForm() {
      axios
        .post("http://localhost:9090/login", {
          pid: this.pid,
          pwd: this.pwd,
        })
        .then((res) => {
          console.log(res);
          this.$router.push("main");
          // this.logMessage = `${data.user.name}님 어서오세요`;
          // this.initForm();
        })
        .catch((err) => {
          console.log(err);
        });
    },
    // initForm() {
    //   this.pid = "";
    //   this.pwd = "";
    // },
  },
};
</script>

<style scoped>
@import url("//fonts.googleapis.com/earlyaccess/nanumgothic.css");
input[type="password"] {
  font-family: "Nanum Gothic", sans-serif !important;
}

.main {
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  border-bottom: 1px solid lightgrey;
}
.container {
  margin-left: 35%;
  width: 50%;
  margin-bottom: 20%;
}
.logo {
  margin-top: 18%;
  margin-bottom: 20px;
  font-size: 24px;
  justify-content: center;
}

#login {
  width: 50%;
  left: 25%;
  background-color: rgb(182, 165, 94);
  border-color: transparent;
  color: white;
}

.account {
  width: 50%;
  display: block;
  margin-bottom: 3px;
  padding: 3px;
  border: 1px solid lightgray;
  border-radius: 3px;
}

#alert {
  border-color: transparent;
}

.register {
  margin-top: 8px;
}

.fa-solid {
  font-size: 12px;
}
</style>
