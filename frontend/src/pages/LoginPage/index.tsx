import React, {useState} from "react";
import {TextField} from "@mui/material";


export default function LoginPage() {
    const [username, setUsername] = useState<string>("");
    const [password, setPassword] = useState<string>("");





    return (
        <div>
            <h1>Login page</h1>


            <TextField value={username} onChange={(event)=>{setUsername(event.target.value)}} />

            <TextField value={password} type="password" onChange={(event)=>{setPassword(event.target.value)}} />

        </ div>
    )
}