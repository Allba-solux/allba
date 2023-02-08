import axios from "axios";
import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    pid: "",
  },
  getters: {
    isLogin(state) {
      return state.pid !== "";
    },
  },
  mutations: {
    setUsername(state, pid) {
      state.pid = pid;
    },
    clearUsername(state) {
      state.pid = "";
    },
  },
  // actions: {
  //   fetch_user(context) {
  //     axios.get('http://localhost:9090/login').then(function (response) {
  //       context.commit(state, response)
  //     })
  //   }
  // }
});
