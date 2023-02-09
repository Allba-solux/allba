<template>
    <div>
        <h2 class="title">지점등록</h2>
        <hr class="line">
<form @submit.prevent="submitForm">
    <div class="container">
        <div class="header">
    <div class="form-floating mb-3">
        <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" v-model="companyName">
        <label for="floatingInput">지점 이름</label> 
    </div>
    <div class="form-floating mb-3">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password" v-model="companyPW">
        <label for="floatingPassword">비밀번호 설정</label>
    </div>

            <div class="form-floating">
                <textarea class="form-control mb-3" placeholder="Leave a comment here" id="floatingTextarea2"
                    style="height: 100px" v-model="companyDescription"></textarea>
                <label for="floatingTextarea2">지점 소개</label>
            </div>

        <div class="d-flex flex-row-reverse gap-2 mt-4">
            <router-link to="/finding"><button type="button" class="btn btn-outline-dark">
                목록
            </button></router-link>
            <button type="submit" class="btn btn-outline-success">저장</button>
        </div>
        </div>
        </div>
    </form>
    </div>
</template>
<script>
import axios from "axios";
export default {
    data() {
        return {
            companyName: '',
            companyPW: '',
            companyDescription: '',
        };
    },
    methods: {
        async submitForm() {
            axios.post('http://localhost:9090/company/new', {
                companyName: this.companyName,
                companyPW: this.companyPW,
                companyDescription: this.companyDescription,
            })
            .then(res => {
                console.log(res);
                alert('지점 등록이 완료되었습니다.')
                this.$router.push('/finding');

            }).catch(err => {
                    console.log(err);
            })
            // .catch()
            // const response = await createPost({
            //     companyCode: this.companyCode,
            //     companyName: this.companyName,
            //     companyPW: this.companyPW,
            //     companyDescription:this.companyDescription,
            // });
            // console.log(response);
            // }
        }

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