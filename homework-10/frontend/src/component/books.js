import React from 'react'
import {Link} from "react-router-dom";
import {Button, Table} from "reactstrap";
import {BookApi} from "../api/api";
import {startState} from "../startAppState";
import axios from "axios";
import {NewBookModel} from "../book/newBookModel";
import {BookMap} from "../book/bookMap";

export class Books extends React.Component {
    state = startState;
    componentDidMount() {
        BookApi.getBooks().then((response) => {
            this.setState({
                books: response.data
            })
        });
    }

    toggleNewBookModel() {
        this.setState({
            newBookModel: !this.state.newBookModel
        });

    }
    toggleEditBookModel(id, title, authorName, genreName) {
        this.setState({
            editBookData: {
                id: id,
                title: title,
                author:
                    {
                        name: authorName
                    },
                genre:
                    {
                        name: genreName
                    }
            },
            editBookModel: !this.state.editBookModel
        })
    }

    deleteBook(id) {
        let Id = Number.parseInt(id);
        axios.delete('http://localhost:8080/books/' + Id).then((response) => {
            this.componentDidMount();
        });
    }


    render() {
        let books = this.state.books.map((book, index) => {
            return (
                <tr key={book.id}>
                    <td>{index + 1}</td>
                    <td><Link to={'/book/' + book.id}>{book.title}</Link></td>
                    <td>{book.author.name}</td>
                    <td>{book.genre.name}</td>
                    <td>
                        <Button color="success" size="small" className="mr-2"
                                onClick={this.toggleEditBookModel.bind(this, book.id, book.title, book.author.name, book.genre.name)}>Edit</Button>
                        <Button color="danger" size="small"
                                onClick={this.deleteBook.bind(this, book.id)}>Delete</Button>
                    </td>
                </tr>
            )
        });
        return (
            <div>
                <h1>Library</h1>
                {this.state.newBookModel && <NewBookModel toggleNewBookModel={this.toggleNewBookModel()} newBookData={this.state.editBookData}/>}
                <Button className="my-3" color="primary" onClick={this.toggleNewBookModel.bind(this)}>Add a
                    book</Button>
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
                    <BookMap books={this.state.books} toggleEditBookModel={this.toggleNewBookModel}
                    deleteBook={this.deleteBook}/>
                    </tbody>
                </Table>
            </div>
        )
    }
}


