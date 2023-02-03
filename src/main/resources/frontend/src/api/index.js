import axios from "axios";

const instance = axios.create({
  baseURL: "http://localhost:9090/",
});

//회원가입 API
function registerUser(userData) {
  return instance.post('signup', userData);
}

//로그인API
function loginUser(userData) {
  return instance.post("login", userData);
}

//학습노트 데이터를 조회하는 API
function fetchPosts() {
  return instance.get('posts');
}

//학습노트 데이터를 등록하는 API 
function createPost(postData) {
  return instance.post('posts', postData);
}

export { registerUser, loginUser, fetchPosts, createPost };
