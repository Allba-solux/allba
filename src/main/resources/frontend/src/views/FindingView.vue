<template>
  <div>
    <h2 class="title">지점찾기</h2>
    <hr class="line" />

    <!-- 입력창 -->
    <div
      class="input-group"
      style="width: 50%; left: 25%; margin-top: 6.5rem; margin-bottom: 1rem"
    >
      <input
        type="text"
        class="form-control"
        placeholder="지점명을 입력하세요"
        v-model="searchName"
      />
      <button
        class="btn btn-outline-secondary"
        type="button"
        id="button-addon2"
        @click="getData"
      >
        <i class="fa-solid fa-magnifying-glass"></i>
      </button>
    </div>

    <router-link to="/register">
      <button
        type="button"
        class="btn btn-outline-secondary"
        id="registerbtn"
        style="margin-bottom: 6.75rem; margin-right: 25%; float: right"
      >
        지점 등록하기
      </button>
    </router-link>

    <hr class="line" />
    <div class="p-5 10" style="width: 88%; margin-left: 6%">
      <div class="row g-5">
        <div
          v-for="user in users"
          v-if="user.companyName.includes(searchName)"
          class="col-3"
        >
          <div class="row">
            <!-- <div class="col-sm-4 col-lg-3"> -->
            <div class="card">
              <div class="card-body">
                <h5 class="card-title mt-1">{{ user.companyName }}</h5>
                <p class="card-text mt-1 mb-2">{{ user.companyDescription }}</p>
                <div class=" d-flex flex-row-reverse gap-2 mt-2 ">
                <button class="btn btn-light" id="show-modal" @click="showModal = true">
                  참가 요청
                </button>
                </div>

                 <Transition name="modal">
    <div v-if="show" class="modal-mask">
      <div class="modal-container">
        <div class="modal-header">
          <slot name="header">Allba </slot>
          <i class="fa-solid fa-clock-rotate-left"></i>
        </div>

        <div class="modal-body">
          <slot name="body">참가요청이 완료되었습니다! </slot>
        </div>

        <div class="modal-input">
          <!--<slot name="text">시급 입력 : </slot>-->
          <input
            type="text"
            class="form-control"
            placeholder="시급을 입력하세요"
            v-model="searchName"
          />
        </div>

        <div class="modal-footer">
          <slot name="footer">
            <button class="btn btn-light" @click="$emit('close')">
              OK
            </button>
          </slot>
        </div>
      </div>
    </div>
  </Transition>

                <Teleport to="body">
                  <!-- use the modal component, pass in the prop -->
                  <modal :show="showModal" @close="showModal = false">
                    <template #header>
                      <h3>Allba</h3>
                    </template>
                  </modal>
                </Teleport>
                <!--<a href="#" class="btn btn-light"> 
                  참가요청
                </a>
                 </div> -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import Modal from "./ModalView.vue";

export default {
  props: {
    companyName: {
      type: String,
    },
  },
  components: {
    Modal,
  },
  data() {
    return {
      users: [],
      companyName: "",
      searchName: "",
      showModal: false,
    };
  },
  methods: {
    getData: function () {
      var vm = this;
      axios
        .get("http://localhost:9090/company/")
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

.line {
  width: 90%;
  margin-left: 5%;
}

h5 {
  font-size: 18px;
}

h5 {
  font-size: 18px;
}


</style>
