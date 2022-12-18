import {BrowserRouter, Route, Routes} from "react-router-dom";
import LoginPage from "../../pages/LoginPage";
import PageNotFound from "../../pages/PageNotFound";
import NavBar from "../NavBar";
import ProjectsPage from "../../pages/ProjectsPage";
import UsersPage from "../../pages/UsersPage";
import AddUserPage from "../../pages/AddUserPage";
import AddProjectPage from "../../pages/AddProjectPage";


export default function myRouter() {


    return (
        <BrowserRouter>
            <NavBar />
            <Routes>
                <Route path="/login" element={<LoginPage />} />
                <Route path="/projekti" element={<ProjectsPage />} />
                <Route path="/uporabniki" element={<UsersPage />} />
                <Route path="/uporabniki/dodaj" element={<AddUserPage />} />
                <Route path="/projekti/dodaj" element={<AddProjectPage />} />
                <Route path="*" element={<PageNotFound />} />
            </Routes>
        </BrowserRouter>
    )
}