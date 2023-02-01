<template>
    <div>
   <div class="row">
   <div class="col-sm-4 col-lg-3">
      <div class="card">
          <div class="card-body">
              <h5 class="card-title">{{ work_day }} {{ work_time }}</h5>
              <p class="card-text" >{{ name }}</p>
              <a href="#" class="btn btn-light" @click="참가요청함수">참가요청</a>
          </div>
      </div>
  </div>  
    </div>
    </div>
</template>
<script>
export default {
    state: ({
        work_day: {
            type: [String,Date,Number]
        },
        work_time: {
            type:Number,
        },
        name: {
            type: String,
        },
    }),
}
</script>
<style >
    
</style>