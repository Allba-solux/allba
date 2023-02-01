<template>
    <div>
            <title>MyPages</title>
            <div>
                <h2 class="title">MyPage</h2>
                <hr class="line">
  <i class="fa-solid fa-user"></i><span class="user">{{$route.params.id}}님</span>
            </div>
                <div>
                    <router-link to="/register">
                        <button type="button" class="btn btn-outline-secondary" id="registerbtn"
                            style="margin-bottom:6.75rem ;margin-right:25%;float:right; background: #F4ECFF">
                            급여 확인하기
                        </button>
                    </router-link>

                </div>
                
                <table class="table caption-top">
                    <caption > 나의 알바</caption>
                    <thead>
                        <tr>
                            <th scope="col">지점명</th>
                            <th scope="col">시간</th>
                            <th scope="col">급여</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>메가커피 눈송점</td>
                            <td> 20:00 ~ 23:00 </td>
                            <td> 9,160 / h </td>
                        </tr>
                
                    </tbody>
                </table>
                
                <table class="table caption-top">
                    <caption> 나의 도와준 사람</caption>
                    <thead>
                        <tr>
                            <th scope="col">이름</th>
                            <th scope="col">시간</th>
                            <th scope="col">횟수</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>유숙명님</td>
                            <td> 20:00 ~ 23:00 </td>
                            <td> 1회 </td>
                        </tr>
                
                    </tbody>
                </table>
                
                
                <table class="table caption-top">
                    <caption> 내가 도와준 사람</caption>
                    <thead>
                        <tr>
                            <th scope="col">이름</th>
                            <th scope="col">시간</th>
                            <th scope="col">횟수</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>유숙명님</td>
                            <td> 20:00 ~ 23:00 </td>
                            <td> 1회 </td>
                        </tr>
                    </tbody>
                </table>

        <h2 class="title">나의 급여</h2>
        <hr class="line">
        
        <table class="table caption-top">
            <caption> </caption>
            <thead>
                <tr>
                    <th scope="col">월</th>
                    <th scope="col">총액</th>
                    <th scope="col">급여내역</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1월</td>
                    <td> 137,400원 </td>
                    <td>
                        <router-link to="/register">
                            <button type="button" class="btn btn-outline-secondary" id="registerbtn"
                                style="margin-bottom:6.75rem ;margin-right:25%;float:right; background: #F4ECFF">
                                급여 확인하기
                            </button>
                        </router-link>
                    </td>
        </tr>
            </tbody>
        </table>
               
        
            <table class="table caption-top">
                <caption> 나의 급여 내역</caption>
                <thead>
                    <tr>
                        <th scope="col">기간</th>
                        <th scope="col">총액</th>
                        <th scope="col">변동사항</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>first week</td>
                        <td> 54,960 </td>
                        <td> + 27,480 </td>
                    </tr>
        
                </tbody>
        
                <tbody>
                    <tr>
                        <td>second week</td>
                        <td> 27,480 </td>
                        <td> </td>
                    </tr>
                </tbody>
        
                <tbody>
                    <tr>
                        <td>third week</td>
                        <td> 27,480 </td>
                        <td> </td>
                    </tr>
        
                </tbody>
        
                <tbody>
                    <tr>
                        <td>fourth week</td>
                        <td> 27,480 </td>
                        <td> </td>
                    </tr>
                </tbody>
        
                <tbody>
                    <tr>
                        <td>fifth week</td>
                        <td> 27,480 </td>
                        <td> </td>
                    </tr>

                </tbody>
            </table>
    </div>
</template>
<script>
</script>
<style scoped>

.title {
            font-weight: 600;
            font-size: 32px;
            margin-top: 48px;
            margin-left: 8%;
        }
    
        .user {
            font-weight: 500;
        }
    
        .line {
            width: 90%;
            margin-left: 5%
        }
    
        h5 {
            font-size: 18px;
        }
    
        table caption {
            padding: 10px;
            background: #F00;
        }
</style>