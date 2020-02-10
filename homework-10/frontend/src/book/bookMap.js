import {Link} from "react-router-dom";
import {Button} from "reactstrap";
import React from "react";

export function BookMap(books){
    return books.map((book, index) => {
        return (
            <tr key={book.id}>
                <td>{index + 1}</td>
                <td><Link to={'/book/' + book.id}>{book.title}</Link></td>
                <td>{book.author.name}</td>
                <td>{book.genre.name}</td>
                <td>
                    <Button color="success" size="small" className="mr-2"
                            onClick={this.props.toggleEditBookModel(book.id, book.title, book.author.name, book.genre.name)}>Edit</Button>
                    <Button color="danger" size="small"
                            onClick={this.props.deleteBook(book.id)}>Delete</Button>
                </td>
            </tr>
        )
    });
}