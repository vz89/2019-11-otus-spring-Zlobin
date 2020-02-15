import React from 'react'
import {Link} from "react-router-dom";
import {Button} from "reactstrap";

export default props => (
    <tr key={props.id}>
        <td>{props.index + 1}</td>
        <td><Link to={'/book/' + props.id}>{props.title}</Link></td>
        <td>{props.authorname}</td>
        <td>{props.genrename}</td>
        <td>
            <Button color="success" size="small" className="mr-2"
                    onClick={props.toggleEditBookModel}>Edit</Button>
            <Button color="danger" size="small"
                    onClick={props.deleteBook}>Delete</Button>
        </td>
    </tr>
)