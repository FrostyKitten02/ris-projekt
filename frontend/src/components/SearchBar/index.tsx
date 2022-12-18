import {Box, InputAdornment, TextField} from "@mui/material";
import SearchIcon from '@mui/icons-material/Search';
import {useEffect, useState} from "react";
import {v4 as uuid} from "uuid";
export default function SearchBar(
    {
        onSearch,
        extraSearchParams
    }:{
        onSearch: (value: string)=>void,
        extraSearchParams?: JSX.Element[]
    }) {
    const [searchString, setSearchString] = useState<string>("");


    useEffect(()=>{
        const timeout = setTimeout(()=>{
            onSearch(searchString)
        },300);
        return (()=>{
            clearTimeout(timeout);
        })
    },[searchString])



    return(
        <Box>
            <Box sx={{display: "flex", flexDirection: "row", gap: 15, paddingBottom: 3}}>
                {extraSearchParams?.map(param=>param)}
            </Box>
            <TextField
                sx={{width: "100%"}}
                variant="outlined"
                onChange={(event)=>{
                    setSearchString(event.target.value)
                }}
                InputProps={{
                    startAdornment: (
                        <InputAdornment position="start">
                            <SearchIcon />
                        </InputAdornment>
                    )
                }}
            />
        </Box>
    )

}