import React from "react";
import {Card} from "react-bootstrap";

let VacationCard = (props) => {
    return (
        <div className={"card"} key={props.id}>
            <Card.Body>
                <Card.Header className={"h-"}>
                    {props.title}

                </Card.Header>

                <Card.Text className={"mt-1"}>
                    {props.description}
                </Card.Text>
            </Card.Body>

            <p>{props.username}</p>
        </div>
    )
};

export default VacationCard;