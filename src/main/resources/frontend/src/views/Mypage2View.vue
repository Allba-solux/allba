<template>
    <div>
            <h2 class="title">나의 급여</h2>
            <hr class="line"></hr>
            
            <div>

  <i class="fa-solid fa-user"></i><span class="user">{{$route.params.id}}님</span>
            </div>
        
        <table class="table caption-top">
            <caption> 이 달의 급여</caption>
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
                        <router-link to="/mypage3/:id">
                            <button type="button" class="btn" id="registerbtn"
                                style="margin-bottom:6.75rem ;margin-right:25%;float:right; background: #D5D4DF">
                                급여 확인하기
                            </button>
                        </router-link>
                    </td>
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
            font-size: 24px;
            margin-top: 48px;
        }
        .fa-solid {
            margin-left: 8%;
            font-size: 24px;
        }
    
    
        .line {
            width: 90%;
            margin-left: 5%
        }
    
        h5 {
            font-size: 18px;
        }
    
        table caption {
            margin-top: 3%;
            padding: 10px;
            background: rgba(255, 253, 242, 0.968);
        }
        .table{
            margin-left: 8%;
            width: 90%;
        }
        #registerbtn{
            position: absolute;
            left: 780px;
            top: 383px;
            width: 150px;
            height: 10spx;
    
        }
</style>