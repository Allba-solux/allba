import Vue from "vue";
import VueRouter from "vue-router";
import FindingView from "../views/FindingView.vue";
import LoginView from "../views/LoginView.vue";
import MainView from "../views/MainView.vue";
import ScheduleView from "../views/ScheduleView.vue";
import RegisterView from "../views/RegisterView.vue";
import NoScheduleView from "../views/NoScheduleView.vue";
import SignupView from "../views/SignupView.vue";
import RoomView from "../views/RoomView.vue";
import Mypage1View from "../views/Mypage1View.vue";
import Mypage2View from "../views/Mypage2View.vue";
import ModalView from "../views/ModalView.vue";

Vue.use(VueRouter);

export default new VueRouter({
  mode: "history",
  routes: [
    {
      path: "/",
      redirect: "/main",
    },
    {
      path: "/main",
      component: MainView,
    },
    {
      path: "/finding",
      component: FindingView,
    },
    {
      path: "/login",
      component: LoginView,
    },
    {
      path: "/schedule",
      component: ScheduleView,
    },
    {
      path: "/register",
      component: RegisterView,
    },
    {
      path: "/noschedule",
      component: NoScheduleView,
    },
    {
      path: "/signup",
      component: SignupView,
    },
    {
      path: "/room",
      component: RoomView,
    },
    {
      path: "/mypage1/:id",
      component: Mypage1View,
    },
    {
      path: "/mypage2/:id",
      component: Mypage2View,
    },
    {
      path: "/modal",
      component: ModalView,
    },
  ],
});
