import axios from "axios";
const api = axios.create({
    baseURL: "http://"+process.env.REACT_APP_BASE_URL,
    timeout: 30000,
    headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
    },
});
//TODO add varibles for name and password for auth on backend!
export default api;