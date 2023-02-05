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
    <tr>
      <th scope="row">1</th>
      <td>지은</td>
      <td>2022-01-19</td>
      <td>(오픈) 9:00~12:00</td>
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
import ScheduleItem from '@/components/ScheduleItem.vue'



export default {
    components: {
        ScheduleItem,
    }
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