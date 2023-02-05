<template>
    <div>
    <h2 class="title">스케쥴링</h2>
    <hr class="line">
 
   <div class="p-4 mt-5" >
        <div class="row g-1">
<table class="table">
  <thead>
    <tr>
      <th scope="col">num</th>
      <th scope="col">name</th>
      <th scope="col">date</th>
      <th scope="col">time</th>
      <th scope="col">btn</th>
    </tr>
</thead>
  <tbody>
    <tr v-for="user in users">
    <th scope="row">1</th>
      <td>{{ userName }}</td>
      <td>{{startDate}} {{ startTime }}</td>
      <td>{{endDate }} {{ endTime }}</td>
      <td><button type="button" class="btn btn-success">수락하기</button></td>
    </tr>
  </tbody>
</table>

        </div>
        </div> 
            </div>
            </div>
    </div>
</template>
<script>
import axios from "axios";
import ScheduleItem from '@/components/ScheduleItem.vue'


export default {
    components: {
        ScheduleItem,
    },
    data() {
        return {
            companyCode: '',
            help: true ,
            startDate: '',
            startTime: '',
            endDate: '',
            endTime: '',
            userName:'', 
        }
    },
    methods: {
    getData: function () {
      var vm = this;
      axios
        .get("http://localhost:9090/scheduler/{companyCode}")
        .then(function (response) {
          console.log(response.data);
          vm.users = response.data;
        })
        .catch(function (error) {
          console.log(error);
        });
    },
  },
}
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
    margin-left: 5%
}

h2 {
  margin: 0;
  font-size: 16px;
}
    
</style>