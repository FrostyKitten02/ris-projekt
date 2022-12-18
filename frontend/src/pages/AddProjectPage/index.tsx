import React, {useState} from "react";
import {Box, Button, TextField, Typography} from "@mui/material";
import api from "../../utils/api";


export default function AddProjectPage() {
    const [title, setTitle] = useState<string>("");

    const [startDate, setStartDate] = useState<string>("");
    const [endDate, setEndDate] = useState<string>("");

    function handleSubmit() {
        api("","").post("/projekt", {
            "naziv" : title,
            "datum_zacetka" : startDate,
            "datum_konca" : endDate
        }, {})
    }


    return (
        <Box sx={{display: "flex", flexDirection: "column", justifyContent: "center", alignItems: "center"}}>
            <Typography variant="h1">Dodaj projekt</Typography>
            <Box sx={{display: "flex", flexDirection: "column", marginTop: 10,gap: "10px", width: "400px"}}>
                <TextField value={title} label="Naziv" variant="filled" onChange={(event)=>{setTitle(event.target.value)}} required />
                <TextField value={startDate} label="Datum začetka(YYYY-MM-DD)" variant="filled" onChange={(event)=>{setStartDate(event.target.value)}} required />
                <TextField value={endDate} label="Datum konca(YYYY-MM-DD)" variant="filled" onChange={(event)=>{setEndDate(event.target.value)}} required />
                <Button onClick={(event)=>{handleSubmit()}} variant="contained">Ustvari</Button>
            </Box>
        </Box>
    )
}