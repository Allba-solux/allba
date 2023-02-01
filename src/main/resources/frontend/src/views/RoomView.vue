<template>
    <div>
        <h2 class="title">대타 등록하기</h2>
        <hr class="line">

    <div class="container">
        <div class="header">
<div class="input-group mb-3">
  <label class="input-group-text" for="inputGroupSelect01">날짜</label>
  <input type="date" class="form-select"  id="inputGroupSelect01">
    <label class="input-group-text" for="inputGroupSelect02">대타시작시간</label>
  <input type="time" class="form-select"  id="inputGroupSelect02">
      <label class="input-group-text" for="inputGroupSelect03">대타끝나는 시간</label>
  <input type="time" class="form-select"  id="inputGroupSelect03">
</div>

            <div class="form-floating">
                <textarea class="form-control mt-3" placeholder="Leave a comment here" id="floatingTextarea2"
                    style="height: 100px"></textarea>
                <label for="floatingTextarea2">내용</label>
            </div>

        <div class="d-flex flex-row-reverse gap-2 mt-4">
            <router-link to="/schedule"><button type="button" class="btn btn-outline-dark">
                목록
            </button></router-link>
            <button type="submit" class="btn btn-outline-success">등록</button>
        </div>
        </div>


       


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
</style>

    
}
</script>
<style scoped>
.title{
    font-weight:600;
    font-size:32px;
    margin-top: 48px;
    margin-left:8%;
}

.line{
    width:90%;
    margin-left:5%
} 
</style>
