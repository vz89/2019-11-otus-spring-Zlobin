import React from "react";
import {Button} from "react-bootstrap";
import {Link} from "react-router-dom";

let VacationRow = (props) => {
    return <tr key={props.id}>
        <td>{props.index + 1}</td>
        <td><Link to={'/vacation/' + props.id}>{props.title}</Link></td>
        <td>{props.description}</td>
        <td>{props.country}</td>
        <td>{props.city}</td>
        <td>{props.daysLeft}</td>
        <td>
            <Button disabled  color="success" size="small" className="mr-2"
                    >Edit</Button>
            <Button color="danger" size="small" onClick={props.deleteVacation}
                    >Delete</Button>
        </td>
    </tr>
};

export default VacationRow;

