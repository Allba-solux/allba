<template>
    <div class="main">
        <div class="container">
            <form @submit.prevent="submitForm">
            <h1 class="logo">Login</h1>
            <input type="text" placeholder="ID" id="id" class="account" v-model="pid">
            <input type="password" placeholder="Password" id="password" class="account" v-model="password">
            <button id="login" class="account" type="submit">login</button>
            <div class="register">
            <router-link to="signup"><i class="fa-solid fa-right-from-bracket"></i><span class="regi"> 회원가입</span></router-link>
            </div>
            {{ logMessage }}
            </form>
        </div>
    </div>

</template>

<script>
import { loginUser } from '@/api/index';

export default {
    data() {
        return {
            //form values
            name: '',
            pid: '',
            pwd: '',
            //log
            logMessage: '',
        };
    },
    methods: {
        async submitForm() {
            const userData = {
                pid: this.pid,
                pwd: this.pwd,
            };
            const { data } = await loginUser(userData);
            console.log(data.user.name);
            this.$router.push('/main');
            // this.logMessage = `${data.user.name}님 어서오세요`;
            this.initForm();
        },
        initForm() {
            this.pid = '';
            this.pwd = '';
        },
    },
};
</script>

<style scoped>
.main {
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    border-bottom: 1px solid lightgrey;
}
.container{
    margin-left:35%;
    width: 50%;
    margin-bottom:20%;
}
.logo {

    margin-top:18%;
    margin-bottom:20px;
    font-size:24px;
    justify-content: center;
}


#login {
    width: 50%;
    left:25%;
    background-color: rgb(182, 165, 94);
    border-color: transparent;
    color: white;
}

.account {
    width:50%;
    display: block;
    margin-bottom: 3px;
    padding: 3px;
    border: 1px solid lightgray;
    border-radius: 3px;
}

#alert {
    border-color: transparent;
}


.register{
    margin-top:8px;
}

.fa-solid{
    font-size:12px;

}

</style>