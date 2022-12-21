import http from "@/http-common";

class userService {
  insert(data) {
    return http.post("/user/insertUser", data);
  }

  login(data) {
    return http.post("/user/login", data);
  }
}

export default new userService();
