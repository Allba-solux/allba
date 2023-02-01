<template lang="">
    <div>
    <h2 class="title">스케쥴링</h2>
    <hr class="line">
     <div class="container">
      <p class="text">아직 등록된 지점이 없습니다.</p> 
      <router-link to="/login"><button type="button" class="btn btn-danger">로그인 하러가기</button></router-link>
      <router-link to="/finding"><button type="button" class="btn btn-warning">우리 지점 찾으러가기</button></router-link>
     </div>
    </div>
</template>
<script>
export default {
    
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

.container{
    margin-left:7%;
    font-size:15px;
}

.text{
    margin-bottom:10px;
    
    

}
</style>