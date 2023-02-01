<template>

<div>
    <h2 class="title">지점찾기</h2>   
    <hr class="line">

    <!-- 입력창 -->
    <div class="input-group" style="width:50%; left:25%;margin-top:6.5rem; margin-bottom:1rem;" >
            <input type="text" class="form-control" placeholder="지점명을 입력하세요" aria-label="Recipient's username" aria-describedby="button-addon2">
            <button class="btn btn-outline-secondary" type="button" id="button-addon2"><i class="fa-solid fa-magnifying-glass"></i></button>
    </div>

        <router-link to="/register">
            <button type="button" class="btn btn-outline-secondary" id="registerbtn" style="margin-bottom:6.75rem ;margin-right:25%;float:right">
            지점 등록하기
            </button>
        </router-link>

    <hr class="line">
    <!-- hi  -->


    <div class="p-5 10" style="width:88%; margin-left:6%;" >
        <div class="row g-5">
   
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
           

        </div>
            </div>
            </div>
</div>

</template>
<script>
export default {

}
</script>
<style scoped >
.title {
    font-weight: 600;
    font-size: 32px;
    margin-top: 48px;
    margin-left: 8%;
    ;
}

.line {
    width: 90%;
    margin-left: 5%
}

h5 {
    font-size: 18px;
}

h5{
    font-size:18px;
}

</style>