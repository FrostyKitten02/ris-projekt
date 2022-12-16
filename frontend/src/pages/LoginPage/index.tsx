import React, {useState} from "react";


export default function LoginPage() {
    const [userName, setUsername] = useState<string>("");
    const [password, setPassword] = useState<string>("");





    return (
        <div>
            <h1>Login page</h1>

            <label>Username</label>
            <input id="username" name="username"></input>

            <label>Username</label>
            <input id="username" name="username"></input>

        </ div>
    )
}