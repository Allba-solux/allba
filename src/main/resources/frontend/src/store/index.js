import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    name: '',
    pid:'',
  },
  getters: {
    isLogin(state) {
      return state.name !== '';
    },
  },
  mutations: {
    setUsername(state, name) {
      state.name = name;
    },
    clearUsername(state) {
      state.username = '';
    },
    inputpid(state) {
      return( pid = state )
    }
  },
});
