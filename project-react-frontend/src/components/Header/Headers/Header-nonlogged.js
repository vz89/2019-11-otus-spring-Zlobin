import {Nav} from "react-bootstrap";
import {NavLink} from "react-router-dom";
import React from "react";


const HeaderNonLogged = (props) => {
    return (<>
            <Nav className={"mr-auto"}>
                <Nav.Link as={NavLink} to="/news">News</Nav.Link>
            </Nav>
            <Nav>
                <Nav.Link as={NavLink} to="/login">Sign in</Nav.Link>
                <Nav.Link as={NavLink} to="/registration">Sign up</Nav.Link>
            </Nav>
        </>
    )

};


export default HeaderNonLogged;