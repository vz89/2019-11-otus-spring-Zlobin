import React from "react";
import {Navbar} from "react-bootstrap";
import {NavLink} from 'react-router-dom'
import HeaderLogged from "./Headers/Header-logged";
import HeaderNonLogged from "./Headers/Header-nonlogged";

const Header = (props) => {
    return (
        <Navbar bg="primary" variant="dark">
            <Navbar.Brand as={NavLink} to="/">HolyVacation</Navbar.Brand>
            {props.isAuth ?
                <HeaderLogged
                    username={props.username}
                    logout={props.logout}
                />
                : <HeaderNonLogged/>}
        </Navbar>
    )
};

export default Header;