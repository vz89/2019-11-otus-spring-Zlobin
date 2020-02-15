import {Button} from "reactstrap";
import React from "react";


export default props => (
    <tr key={props.id}>
        <td>{props.index + 1}</td>
        <td>{props.text}</td>
        <td>
            <Button color="danger" size="small"
                    onClick={props.deleteComment}>Delete</Button>
        </td>
    </tr>
)

