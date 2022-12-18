import { AppBar, Box, Button, Container, IconButton, Menu, MenuItem, Toolbar, Tooltip, Typography } from "@mui/material";
import MenuIcon from '@mui/icons-material/Menu';

import {v4 as uuid} from "uuid";
import React, {useRef, useState} from "react";
import {Link, useNavigate} from "react-router-dom";

interface pageInfo{
    path: string,
    name: string,
}

const pages: pageInfo[] = [
    {path: "/login", name: "Login"},
    {path: "/projekti", name: "Projekti"},
    {path: "/uporabniki", name: "Uporabniki"}
]


export default function NavBar() {
    const navigate = useNavigate();


    return (
        <AppBar position="static">
            <Toolbar>
                {pages.map(page=>{
                    return(
                        <Button key={uuid()} color="inherit" onClick={(event)=>{navigate(page.path)}}>
                            <Typography variant="body1">{page.name}</Typography>
                        </Button>
                    );
                })}
            </Toolbar>
        </AppBar>
    )
}