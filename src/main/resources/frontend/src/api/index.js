import axios from "axios";

const instance = axios.create({
  baseURL: "http://localhost:8080/",
});

function registerUser(userData) {
  return instance.post('signup', userData);
}

function loginUser(userData) {
  return instance.post("login", userData);
}

function fetchPosts() {
  return instance.get('posts');
}

function createPost(postData) {
  return instance.post('posts', postData);
}

export { registerUser, loginUser, fetchPosts, createPost };
