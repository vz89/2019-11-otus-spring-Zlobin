import {Card} from "react-bootstrap";
import React from "react";


const VacationNewsCard = (props) => {
    return (
        <div className={"card"} key={props.id}>
            <Card.Img variant={"top"} src={props.urlToImage} />
            <Card.Body>
                <Card.Header className={"h-"}>
                    {props.title}

                </Card.Header>

                <Card.Text className={"mt-1"}>
                    {props.description}
                </Card.Text>
            </Card.Body>

            <a href={props.url} target="_blank">Link</a>
        </div>
    )
};

export default VacationNewsCard;