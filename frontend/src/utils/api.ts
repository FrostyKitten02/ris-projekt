import axios from "axios";
import {Buffer} from "buffer";
const api = (username: string, password: string) => {
    const override = process.env.REACT_APP_OVERRIDE_CREDENTIALS;
    if (override === "true") {
        username = process.env.REACT_APP_ADMIN_USERNAME??"";
        password = process.env.REACT_APP_ADMIN_PASSWORD??"";
    }
    console.log(username, "  ", password)
    const buff = Buffer.from((username + ":" + password), "utf8");
    const base64auth = buff.toString('base64');

    return axios.create({
        baseURL: process.env.REACT_APP_BASE_URL,
        timeout: 30000,
        headers: {
            'Content-type': 'application/json',
            'Authorization': `Basic ${base64auth}`,
            'Access-Control-Allow-Origin': "*",
            Accept: "application/json",
        },
    });
}

export default api;