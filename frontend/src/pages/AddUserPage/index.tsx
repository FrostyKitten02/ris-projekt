import {Box, Button, FormControlLabel, Switch, TextField, Typography} from "@mui/material";
import React, {useState} from "react";
import dateUtils from "../../utils/dateUtils";
import api from "../../utils/api";

export default function AddUserPage() {

    const [name, setName] = useState<string>("");
    const [lastname, setLastName] = useState<string>("");

    const [birthDate, setBirthDate] = useState<string>("");
    const [employmentDate, setEmploymentDate] = useState<string>("");

    const [country, setCountry] = useState<string>("");
    const [isEmployed, setIsEmployed] = useState<boolean>(true);
    const [isActive, setIsActive] = useState<boolean>(true);

    const [email, setEmail] = useState<string>("");
    const [username, setUsername] = useState<string>("");
    const [password, setPassword] = useState<string>("");

    function handleSubmit() {

        api("","").post("/uporabnik",{
            "uporabniskoIme" : username,
            "ime" : name,
            "priimek" : lastname,
            "datumRojstva" : birthDate,
            "datumZaposlitve" : employmentDate,
            "drzavljanstvo" : country,
            "jeZaposlen" : isEmployed,
            "aktiven" : isActive,
            "geslo" : password,
            "email" : email
        },{}).then(res=>{
            console.log(res.data);
        }).catch(err=>{
            console.error(err);
        })




    }

    return(
        <Box sx={{display: "flex", flexDirection: "column", justifyContent: "center", alignItems: "center"}}>
            <Typography variant="h1">Dodaj uporabnika</Typography>
            <Box sx={{display: "flex", flexDirection: "column", marginTop: 10,gap: "10px", width: "400px"}}>
                <TextField value={username} label="Uporabniško ime" variant="filled" onChange={(event)=>{setUsername(event.target.value)}} required />
                <TextField value={password} label="Geslo" type="password" variant="filled" onChange={(event)=>{setPassword(event.target.value)}} required />
                <Box sx={{display: "flex", gap: "10px"}}>
                    <TextField value={name} label="Ime" variant="filled" onChange={(event)=>{setName(event.target.value)}} required />
                    <TextField value={lastname} label="Priimek" variant="filled" onChange={(event)=>{setLastName(event.target.value)}} required />
                </ Box>


                <TextField value={birthDate} label="Datum rojstva(YYYY-MM-DD)" variant="filled" onChange={(event)=>{setBirthDate(event.target.value)}} required />
                <TextField value={employmentDate} label="Datum zaposlitve(YYYY-MM-DD)" variant="filled" onChange={(event)=>{setEmploymentDate(event.target.value)}} required />

                <TextField value={country} label="Državljanstvo" variant="filled" onChange={(event)=>{setCountry(event.target.value)}} required />

                <Box sx={{display: "flex", gap: "10px", alignItems: "center", justifyContent: "center"}}>
                    <FormControlLabel control={<Switch
                        checked={isEmployed}
                        onChange={(event)=>{
                            setIsEmployed(event.target.checked);
                        }}
                    />} label="Je zaposlen" />

                    <FormControlLabel control={<Switch
                        checked={isActive}
                        onChange={(event)=>{
                            setIsActive(event.target.checked);
                        }}
                    />} label="Je aktiven" />
                </ Box>

                <TextField value={email} label="Email" variant="filled" onChange={(event)=>{setEmail(event.target.value)}} required />

                <Button onClick={(event)=>{handleSubmit()}} variant="contained">Ustvari</Button>
            </ Box>
        </Box>
    )

}