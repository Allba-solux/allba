import axios from "axios";
import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    pid: "",
    name: "",
  },
  getters: {
    isLogin(state) {
      return state.pid !== "";
    },
  },
  mutations: {
    setPid(state, pid) {
      state.pid = pid;
    },
    setName(state, name) {
      state.name = name;
    },
    clearPid(state) {
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
