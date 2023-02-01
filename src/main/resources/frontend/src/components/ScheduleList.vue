<template>
    <div>
    <h2 class="title">스케쥴링</h2>
    <hr class="line">
 
   <div class="p-4 mt-5" >
        <div class="row g-1">
            <!-- <div v-for="post in posts": key="post.id" class="col-4"> -->
             <ScheduleItem ></ScheduleItem>
        
            <!-- </div> -->

 
            <div class="row">
               
                <div class="col-sm-4 col-lg-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title" style="">눈송행복점</h5>
                            <p class="card-text" >12/13</p>
                            <a href="#" class="btn btn-light">참가요청</a>
    
                        </div>
                    </div>
                </div>           
          

                 <div class="col-sm-4 col-lg-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">눈송행복점</h5>
                            <p class="card-text; my-1">12/13</p>
                            <a href="#" class="btn btn-light">참가요청</a>
            
                        </div>
                    </div>
                </div>
   

                <div class="col-sm-4 col-lg-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">눈송행복점</h5>
                            <p class="card-text; my-1">12/13</p>
                            <a href="#" class="btn btn-light">참가요청</a>
                        </div>
                    </div>
                </div>

                                <div class="col-sm-4 col-lg-3">
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title">눈송행복점</h5>
                                            <p class="card-text; my-1">12/13</p>
                                            <a href="#" class="btn btn-light">참가요청</a>
                                        </div>
                                    </div>
                                </div>
                   <div class="d-flex flex-row-reverse gap-2 mt-4">
            <router-link to="/room"><button type="button" class="btn btn-warning">
                대타 신청하기
            </button></router-link>
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