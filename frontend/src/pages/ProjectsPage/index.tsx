import {
    Box,
    Button, FormControlLabel, Input,
    Paper, Switch,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow, TextField,
    Typography
} from "@mui/material";
import api from "../../utils/api";
import React, {useEffect, useState} from "react";
import {v4 as uuid} from "uuid";
import {useNavigate} from "react-router-dom";
import SearchBar from "../../components/SearchBar";


export default function ProjectsPage() {
    const [projects, setProjects] = useState<any[]>([]);
    const [searchString, setSearchString] = useState<string>("");
    const [hasResposibleEmployee, setHasResponsibleEmployee] = useState<boolean>(false)
    const [minEmployees, setMinEmployees] = useState<number>(0)



    const navigate = useNavigate();


    useEffect(()=>{
        api("","").get("/projekt",{})
            .then(res=>{
                const resArr = res.data as unknown as any[];
                setProjects(resArr);
            }).catch(err=>{
                console.error(err);
            })
    },[])


    useEffect(()=>{
        api("","").post("/projekt/search",{
            "searchString": searchString,
            "minZaposelenih": minEmployees,
            "imaOdgovornega": hasResposibleEmployee,
        },{}).then(res=>{
            setProjects(res.data);
        })
    },[searchString, hasResposibleEmployee, minEmployees])

    function search(value: string): void {
        console.log("searching! ", value)
        setSearchString(value);
    }

    return(
        <Box sx={{display: "flex", flexDirection: "column", alignItems: "center", justifyContent: "center", gap: "10px"}}>
            <Typography variant="h1">Projekti</Typography>
            <SearchBar
                onSearch={search}
                extraSearchParams={[
                    <FormControlLabel
                        key={uuid()}
                        control={
                            <Switch
                                key={uuid()}
                                checked={hasResposibleEmployee}
                                onChange={(event)=>{
                                    setHasResponsibleEmployee(event.target.checked);
                                }}
                            />}
                        label="Ima odgovornega" />,
                    <TextField
                        key={uuid()}
                        value={minEmployees}
                        onChange={(event)=>{setMinEmployees(Number.parseInt(event.target.value))}}
                        type="number"
                        variant="filled"
                        label="Min zaposlenih"
                    />
                ]}
            />
            <Button variant="contained" onClick={(event)=>{navigate("/projekti/dodaj")}}>Dodaj</Button>
            <TableContainer sx={{ minWidth: "500px", maxWidth: "800px" }} component={Paper}>
                <Table size="small">
                    <TableHead>
                        <TableRow>
                            <TableCell>Naziv</TableCell>
                            <TableCell align="center">Datum začetka</TableCell>
                            <TableCell align="right">Datum konca</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {projects.map(project=>{
                            return(
                                <TableRow key={uuid()} onClick={(event)=>{
                                    console.log(project.id)
                                    //todo view single project!!
                                }}>
                                    <TableCell>{project.naziv}</TableCell>
                                    <TableCell align="center">{project.datum_zacetka}</TableCell>
                                    <TableCell align="right">{project.datum_konca}</TableCell>
                                </TableRow>
                            )
                        })}
                    </TableBody>
                </Table>
            </TableContainer>
        </Box>
    )

}