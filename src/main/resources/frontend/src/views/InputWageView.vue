<template>
  <div>
    <h2 class="title">시급입력</h2>
    <hr class="line" />
    <form @submit.prevent="submitForm">
      <div class="container">
        <div class="header">
          <div class="form-floating mb-3">
            <input
              type="text"
              class="form-control"
              id="floatingInput"
              placeholder="name@example.com"
              v-model="name"
            />
            <label for="floatingInput">시급을 입력하세요</label>
          </div>

          <div class="d-flex flex-row-reverse gap-2 mt-4">
            <router-link to="/mypage1/:id"
              ><button type="button" class="btn btn-outline-dark">
                저장
              </button></router-link
            >
          </div>
        </div>
      </div>
    </form>
  </div>
</template>
<script>
import axios from "axios";

export default {
  data() {
    return {
      wage: "",
    };
  },
  methods: {
    async submitForm() {
      const response = await createPost({
        wage: this.wage,
      });
      console.log(response);
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

.line {
  width: 90%;
  margin-left: 5%;
}
</style>
