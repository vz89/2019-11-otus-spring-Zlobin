import {Nav} from "react-bootstrap";
import {NavLink} from "react-router-dom";
import React from "react";


const HeaderLogged = (props) => {
    return (<>
            <Nav className={"mr-auto"}>
                <Nav.Link as={NavLink} to="/news">News</Nav.Link>
                <Nav.Link as={NavLink} to="/vacations">My Vacations</Nav.Link>
                <Nav.Link as={NavLink} to="/messages">Messages</Nav.Link>
            </Nav>
            <Nav>
                <Nav.Link as={NavLink} to="/user">{props.username}</Nav.Link>
                <Nav.Link as={NavLink} to="" onClick={props.logout}>Logout</Nav.Link>
            </Nav>
        </>
    )
};
export default HeaderLogged;