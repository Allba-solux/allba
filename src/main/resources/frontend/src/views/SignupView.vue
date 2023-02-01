<template>
    <div class="container">
        <h2 class="title">회원가입</h2>
        <hr class="line">

        <form v-on:submit.prevent="submitForm">
        <div>
            <h3 class="join_title"><label for="pswd1">ID</label></h3>
            <span class="box int_pass">
              <input type="text" id="id" class="int" maxlength="20" v-model="pid">
            </span>
        </div>
            <!-- PW1 -->
        <div>
            <h3 class="join_title"><label for="pswd1">PW</label></h3>
            <span class="box int_pass">
                <input type="text" id="pswd1" class="int" maxlength="20" v-model="pwd">
           </span>
        </div>

       <!-- NAME -->
        <div>
            <h3 class="join_title"><label for="name">이름</label></h3>
            <span class="box int_name">
            <input type="text" id="name" class="int" maxlength="20" v-model="name">
            </span>       
        </div>
            <!-- EMAIL -->
        <div>
        <h3 class="join_title"><label for="email">E-mail</label></h3>
        <span class="box int_email">
        <input type="text" id="email" class="int" maxlength="100" placeholder="optional" v-model="email">
        </span>
        </div>

        <!-- MOBILE -->
        <div>
        <h3 class="join_title"><label for="phoneNo">전화번호</label></h3>
        <span class="box int_mobile">
            <input type="tel" id="mobile" class="int" maxlength="16" placeholder="Write Your Phone Number" v-model="phone">
        </span>
        </div>
        <!-- JOIN BTN-->
        <div class="btn_area">
        <button type="submit" id="btnJoin">
            <span>가입하기</span>
        </button>
        </div>   
        
         <p>{{ logMessage }}</p>
        </form>    
        </div> 
        </div> 
    </body>
    </html>
    </div>
</template>
<script>
import { registerUser } from '@/api/index';

export default {
    data(){
        return {
            //form value
            pid: '',
            name: '',
            pwd: '',
            phone: '',
            email: '',
            //log
            logMessage:'',
        };
    },
    methods: {
        async submitForm(){
            console.log('폼제출');
            const userData = {
                pid: this.pid,
                pwd: this.pwd,
                name: this.name,
                phone: this.phone,
                email: this.email,
            }
            const { data } = await registerUser(userData);
            console.log(data.name);
            this.logMessage = `${data.name}님 환영합니다`;
            this.initForm();
        },
        initForm() {
            this.pid = '';
            this.pwd = '';
            this.name = '';
            this.phone = '';
            this.email = '';
        }
        
    },
};
</script>
<style scoped>
.line{
    margin-bottom:5%;

}

h2{
    font-size:23px;

}
html {
            width: 70%;
        }

        .container{
            width: 60%;
            margin-top:50px;
        }
    
        body {
            margin-left: 35%;
            width: 50%;
            margin-bottom: 20%;
        }
    
        #logo {
            margin-top: 18%;
            margin-bottom: 20px;
            font-size: 24px;
            justify-content: center;
        }
    
        #header {
            padding-top: 62px;
            padding-bottom: 20px;
            text-align: center;
        }
    
        #wrapper {
            position: relative;
            height: 100%;
        }
    
        #content {
            position: absolute;
            left: 50%;
            transform: translate(-50%);
            width: 460px;
        }
    
    
    
    
        /* 입력폼 */
    
    
        h3 {
            margin: 19px 0 8px;
            font-size: 14px;
            font-weight: 700;
        }
    
    
        .box {
            display: block;
            width: 100%;
            height: 51px;
            border: solid 1px #dadada;
            padding: 10px 14px 10px 14px;
            box-sizing: border-box;
            background: #fff;
            position: relative;
        }
    
        .int {
            display: block;
            position: relative;
            width: 100%;
            height: 29px;
            border: none;
            background: #fff;
            font-size: 15px;
        }
    

    
        .box.int_id {
            padding-right: 110px;
        }
    
        .box.int_pass {
            padding-right: 40px;
        }
    
        .box.int_pass_check {
            padding-right: 40px;
        }
    
        .pswdImg {
            width: 18px;
            height: 20px;
            display: inline-block;
            position: absolute;
            top: 50%;
            right: 16px;
            margin-top: -10px;
            cursor: pointer;
        }
    
        #bir_wrap {
            display: table;
            width: 100%;
        }
    
        #bir_yy {
            display: table-cell;
            width: 147px;
    
        }
    
        #bir_mm {
            display: table-cell;
            width: 147px;
            vertical-align: middle;
        }
    
        #bir_dd {
            display: table-cell;
            width: 147px;
        }
    
        #bir_mm,
        #bir_dd {
            padding-left: 10px;
        }
    
        select {
            width: 100%;
            height: 29px;
            font-size: 15px;
            background: #fff url(https://static.nid.naver.com/images/join/pc/sel_arr_2x.gif) 100% 50% no-repeat;
            background-size: 20px 8px;
            -webkit-appearance: none;
            display: inline-block;
            text-align: start;
            border: none;
            cursor: default;
        }
    
        /* 에러메세지 */
    
        .error_next_box {
            margin-top: 9px;
            font-size: 12px;
            color: red;
            display: none;
        }
    
        #alertTxt {
            position: absolute;
            top: 19px;
            right: 38px;
            font-size: 12px;
            color: red;
            display: none;
        }
    
        /* 버튼 */
    
        .btn_area {
            margin: 30px 0 91px;
        }
    
        #btnJoin {
            width: 100%;
            padding: 21px 0 17px;
            border-color: transparent;
            cursor: pointer;
            color: #fff;
            background-color: rgb(182, 165, 94);
        }
</style>