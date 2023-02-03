<template>
  <div>
    <title>MyPages</title>
    <div>
      <h2 class="title">MyPage</h2>
      <hr class="line" />
      <i class="fa-solid fa-user"></i
      ><span class="user">{{ $route.params.id }}님</span>
    </div>
    <div>
      <router-link to="/mypage2/:id">
        <button
          type="button"
          class="btn"
          id="registerbtn"
          style="
            margin-bottom: 3rem;
            margin-right: 25%;
            float: right;
            background-color: #d5d4df;
          "
        >
          급여 확인하기
        </button>
      </router-link>
    </div>

    <table class="table caption-top">
      <caption>
        나의 알바
      </caption>
      <thead>
        <tr>
          <th scope="col">지점명</th>
          <th scope="col">시간</th>
          <th scope="col">급여</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>메가커피 눈송점</td>
          <td>20:00 ~ 23:00</td>
          <td>9,160 / h</td>
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
          <td>유숙명님</td>
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
<script></script>
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
  width: 200px;
  height: 50spx;
  left: 900px;
  top: 240px;
}
</style>
