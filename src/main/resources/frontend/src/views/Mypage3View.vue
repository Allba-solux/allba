<template>
  <div>
    <title>MyPages</title>
    <div>
      <h2 class="title">나의 급여</h2>
      <hr class="line" />
      <i class="fa-solid fa-user"></i
      ><span class="user">{{ $route.params.id }}님</span>
    </div>

    <table class="table caption-top">
      <caption>
        상세 급여 내역
      </caption>
      <thead>
        <tr>
          <th scope="col">기간</th>
          <th scope="col">총액</th>
          <th scope="col">변동사항</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>first week</td>
          <td>54,960</td>
          <td>+ 27,480</td>
        </tr>
      </tbody>

      <tbody>
        <tr>
          <td>second week</td>
          <td>27,480</td>
          <td></td>
        </tr>
      </tbody>

      <tbody>
        <tr>
          <td>third week</td>
          <td>27,480</td>
          <td></td>
        </tr>
      </tbody>

      <tbody>
        <tr>
          <td>fourth week</td>
          <td>27,480</td>
          <td></td>
        </tr>
      </tbody>

      <tbody>
        <tr>
          <td>fifth week</td>
          <td>27,480</td>
          <td></td>
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
  margin-top: 48px;
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

.table {
  margin-left: 8%;
  width: 90%;
}

table caption {
  margin-top: 3%;
  padding: 10px;
  background: rgba(255, 253, 242, 0.968);
}
</style>
