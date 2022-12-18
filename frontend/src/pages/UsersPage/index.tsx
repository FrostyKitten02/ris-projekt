import {Box, Button, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Typography} from "@mui/material";
import React, {useEffect, useState} from "react";
import api from "../../utils/api";
import {v4 as uuid} from "uuid";
import {useNavigate} from "react-router-dom";


export default function UsersPage() {
    const [users, setUsers] = useState<any[]>([]);
    const navigate = useNavigate();

    useEffect(()=>{
        api("","").get("/uporabnik",{})
            .then(res=>{
                const resArr = res.data as unknown as any[];
                console.log(resArr);
                setUsers(resArr);
            }).catch(err=>{
            console.error(err);
        })
    },[])

    return(
        <Box sx={{display: "flex", flexDirection: "column", alignItems: "center", justifyContent: "center"}}>
            <Typography variant="h1">Uporabniki</Typography>
            <Button variant="contained" onClick={(event)=>{navigate("/uporabniki/dodaj")}}>Dodaj</Button>
            <TableContainer sx={{ minWidth: "500px", maxWidth: "800px" }} component={Paper}>
                <Table size="small">
                    <TableHead>
                        <TableRow>
                            <TableCell>Ime</TableCell>
                            <TableCell align="center">Priimek</TableCell>
                            <TableCell align="right">Datum rojstva</TableCell>
                            <TableCell align="right">Email</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {users.map(user=>{
                            return(
                                <TableRow key={uuid()} onClick={(event)=>{
                                    console.log(user.id)
                                    //todo view single project!!
                                }}>
                                    <TableCell>{user.ime}</TableCell>
                                    <TableCell align="center">{user.priimek}</TableCell>
                                    <TableCell align="right">{user.datumRojstva}</TableCell>
                                    <TableCell align="right">{user.email}</TableCell>
                                </TableRow>
                            )
                        })}
                    </TableBody>
                </Table>
            </TableContainer>
        </Box>
    )
}