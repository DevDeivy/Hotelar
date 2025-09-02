import { Register } from "./register/register";
import { Routes } from "@angular/router";
import { Login } from "./login/login";
import { Home } from "../home/home";

export const rout: Routes = [
    {
        path: 'register',
        component: Register
    },
    {
        path: 'login',
        component: Login
    },
    {
        path: 'home',
        component: Home
    },
    {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
    },
    {
        path: '**',
        redirectTo: 'home'
    }
];