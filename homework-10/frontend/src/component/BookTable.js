import Book from "./Book";
import React, {Component} from "react";
import {Table} from "reactstrap";


export class BookTable extends Component {
    render() {
        const books = this.props.books.map((book, index) => {
            return (
                <Book
                    id={book.id}
                    index={index}
                    title={book.title}
                    authorname={book.author.name}
                    genrename={book.genre.name}
                    toggleEditBookModel={() => this.props.toggleEditBookModel(book.id, book.title, book.author.name, book.genre.name)}
                    deleteBook={() => this.props.deleteBook(book.id)}
                />
            )
        });
        return (
            <Table>
                <thead>
                <tr>
                    <th>#</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Genre</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                {books}
                </tbody>
            </Table>
        )
    }
}
