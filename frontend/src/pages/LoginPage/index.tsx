import React, {useContext, useState} from "react";
import {Box, Button, TextField, Typography} from "@mui/material";





export default function LoginPage() {
    const [username, setUsername] = useState<string>("");
    const [password, setPassword] = useState<string>("");



    const login = (username: string, password: string)=>{
        //user.setUserCredentials({username: username, password: password});
        console.log(username, " ", password);
    }

    return (
        <Box sx={{display: "flex", flexDirection: "column", alignItems: "center", justifyContent: "center", gap: "20px"}}>
            <Typography variant="h2">Login page</Typography>
            <Box sx={{display: "flex", flexDirection: "column", gap: "10px", width: "200px"}}>
                <TextField value={username} label="Uporabniško ime" variant="filled" onChange={(event)=>{setUsername(event.target.value)}} required />
                <TextField value={password} label="Geslo" type="password" variant="filled" onChange={(event)=>{setPassword(event.target.value)}} required />
                <Button onClick={(event)=>{login(username,password)}} variant="contained">Prijava</Button>
            </ Box>
        </ Box>
    )
}