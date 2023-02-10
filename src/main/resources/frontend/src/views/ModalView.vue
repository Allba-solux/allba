<script>
export default {
  props: {
    show: Boolean,
  },
};
function radioChange(event) {
  var selected = document.querySelector('input[name="radioBtn"]:checked').value;
  console.log("순수 js selected : ", selected);
}

</script>

<template>
  <Transition name="modal">
    <div v-if="show" class="modal-mask">
      <div class="modal-container">
        <div class="modal-header">
          <slot name="header">Allba </slot>
          <i class="fa-solid fa-clock-rotate-left"></i>
        </div>

        <div class="modal-body">
        </div>


        <div class="modal-input">
          <!--<slot name="text">시급 입력 : </slot>-->

                    <div class="input-group m-1">
                          <label class="input-group-text" for="inputGroupSelect02"
              >비밀번호</label
            >
          <input
            type="password"
            class="form-control"

            v-model="companyPW""

          />
          </div>
                     <div class="input-group m-1">
                          <label class="input-group-text" for="inputGroupSelect02"
              >  시급  </label
            >
          <input
            type="text"
            class="form-control"
            v-model="searchName"
          />
          </div>

            <div class="input-group m-1">
                          <label class="input-group-text" for="inputGroupSelect02"
              >요일</label
            >
            <select class="form-select" aria-label="Default select example" v-model="part">
  <option value="오픈">주말</option>
  <option value="미들">평일</option>
</select>
                </div>
                <div class="input-group m-1">
            <label class="input-group-text" for="inputGroupSelect02"
              >타임</label
            >
            <select class="form-select" aria-label="Default select example" v-model="part">
  <option value="오픈">오픈</option>
  <option value="미들">미들</option>
  <option value="마감">마감</option>
</select>
</div>


            </div>



        <div class="modal-footer">
          <slot name="footer">
            <button class="btn btn-outline-danger m-1 mt-2 " @click="$emit('close')">OUT</button>
            <button class="btn btn-outline-success m-1 mt-2" @click="$emit('close')">OK</button>
          </slot>

        </div>
      </div>
    </div>
  </Transition>
</template>

<style>
@import url("//fonts.googleapis.com/earlyaccess/nanumgothic.css");
input[type="password"] {
  font-family: "Nanum Gothic", sans-serif !important;
}


.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(255, 253, 242, 0.968);
  display: flex;
  transition: opacity 0.3s ease;
}

.modal-container {
  width: 300px;
  margin: auto;
  padding: 20px 30px;
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
  transition: all 0.3s ease;
}

.modal-header h3 {
  margin-top: 0;
  color:black;
}

.modal-body {
  margin: 20px 0;
}

.modal-default-button {
  float: right;
  border-radius: 15px;
}

/*
 * The following styles are auto-applied to elements with
 * transition="modal" when their visibility is toggled
 * by Vue.js.
 *
 * You can easily play with the modal transition by editing
 * these styles.
 */

.modal-enter-from {
  opacity: 0;
}
.modal-leave-active {
  transition: opacity 0.3s ease 0.2s;
}

.modal-enter,
.modal-leave-to {
  opacity: 0;

 .modal-window {
    opacity: 0;
    transform: translateY(-20px);
  }
}


.modal-enter-from .modal-container,
.modal-leave-to .modal-container {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}
</style>