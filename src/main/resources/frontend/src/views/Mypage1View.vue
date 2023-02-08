<template>
  <div>
    <title>MyPages</title>
    <div>
      <h2 class="title">MyPage</h2>
      <hr class="line" />
      <i class="fa-solid fa-user"></i
      ><span class="user">{{ $store.state.pid }}님</span>
    </div>

    <table class="table caption-top">
      <caption>
        나의 알바
      </caption>
      <thead>
        <tr>
          <th scope="col">지점명</th>
          <th scope="col">2월 근무 시간</th>
          <th scope="col">총 급여</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>메가커피 눈송점</td>
          <td>48</td>
          <td>300000</td>
        </tr>
      </tbody>
    </table>

    <table class="table caption-top">
      <caption>
        나의 도와준 사람
      </caption>
      <thead>
        <tr>
          <th scope="col">이름</th>
          <th scope="col">시간</th>
          <th scope="col">횟수</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>김순헌</td>
          <td>20:00 ~ 23:00</td>
          <td>1회</td>
        </tr>
      </tbody>
    </table>

    <table class="table caption-top">
      <caption>
        내가 도와준 사람
      </caption>
      <thead>
        <tr>
          <th scope="col">이름</th>
          <th scope="col">시간</th>
          <th scope="col">횟수</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>유숙명님</td>
          <td>20:00 ~ 23:00</td>
          <td>1회</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  props: {
    id: {
      type: String,
    },
    //company_id: {
    //type: String,
    //},
  },
  data() {
    return {
      users: [],
      user_id: "",
      company_id: "",
    };
  },

  methods: {
    getData: function () {
      var vm = this;
      axios
        .get("http://localhost:9090/user/{user_id}/mypage")
        .then(function (response) {
          console.log(response.data);
          vm.users = response.data;
        })
        .catch(function (error) {
          console.log(error);
        });
    },
  },
};
</script>
<style scoped>
.title {
  font-weight: 600;
  font-size: 32px;
  margin-top: 48px;
  margin-left: 8%;
}

.user {
  font-weight: 500;
  font-size: 24px;
}
.fa-solid {
  margin-left: 8%;
  font-size: 24px;
}

.line {
  width: 90%;
  margin-left: 5%;
}

h5 {
  font-size: 18px;
}

table caption {
  margin-top: 3%;
  padding: 10px;
  background-color: rgba(255, 253, 242, 0.968);
}
.table {
  margin-left: 8%;
  width: 90%;
}

#registerbtn {
  margin-left: 2%;
  position: absolute;
  width: 130px;
  height: 30spx;
  left: 935px;
  top: 250px;
  background-color: white;
  border-color: black;
}
</style>
