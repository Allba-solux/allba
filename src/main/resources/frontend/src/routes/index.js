import Vue from 'vue';
import VueRouter from 'vue-router';
import FindingView from '../views/FindingView.vue';
import LoginView from '../views/LoginView.vue';
import MainView from '../views/MainView.vue';
import ScheduleView from '../views/ScheduleView.vue';
import CalendarView from '../views/CalendarView.vue';
import RegisterView from '../views/RegisterView.vue';
import NoScheduleView from '../views/NoScheduleView.vue';
import SignupView from '../views/SignupView.vue';
import MypageView from '../views/MypageView.vue';
import RoomView from '../views/RoomView.vue';

Vue.use(VueRouter);

export default new VueRouter({
  mode: 'history',
  routes: [
    {
    path: '/',
    redirect: '/findng',
    },
    {
    path : '/main',
    component:MainView,
    },
    {
    path: '/finding',
    component:FindingView,
    },
    {
    path:'/login',
    component:LoginView,
    },
    {
    path:'/schedule',
    component:ScheduleView,
    },
    {
      path: '/calendar',
      component: CalendarView,
    },
    {
      path: '/register',
      component:RegisterView
    },
    {
      path:'/noschedule',
      component:NoScheduleView
    },
    {
      path:'/signup',
      component:SignupView
    },
    {
      path:'/mypage/:id',
      component:MypageView
    },
    {
      path: '/room',
      component:RoomView
    },


  ]
})