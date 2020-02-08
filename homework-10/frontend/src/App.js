import React, {Component} from 'react';
import {Button, FormGroup, Input, Label, Modal, ModalBody, ModalFooter, ModalHeader, Table} from 'reactstrap';
import axios from "axios";

import {Link} from "react-router-dom";

class App extends Component {
    state = {
        books: [],
        newBookData: {
            id: '',
            title: '',
            author:
                {
                    name: ''
                },
            genre:
                {
                    name: ''
                }
        },
        editBookData: {
            id: '',
            title: '',
            author:
                {
                    name: ''
                },
            genre:
                {
                    name: ''
                }
        },
        newBookModel: false,
        editBookModel: false
    };

    componentDidMount() {
        axios.get('http://localhost:8080/books').then((response) => {
            this.setState({
                books: response.data
            })
        });
    }

    toggleNewBookModel() {
        this.setState({
            newBookModel: !this.state.newBookModel
        })
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

    addBook() {
        axios.post('http://localhost:8080/books', this.state.newBookData).then((response) => {
            console.log(response);
            this.setState({
                newBookModel: false,
                newBookData: {
                    title: '',
                    author:
                        {
                            name: ''
                        },
                    genre:
                        {
                            name: ''
                        }
                }
            });
            this.componentDidMount();
        });

    }

    editBook(id) {
        let Id = Number.parseInt(id);
        axios.put('http://localhost:8080/books/' + Id, this.state.editBookData).then((response) => {
            this.setState({
                editBookModel: !this.state.editBookData,
                editBookData: {
                    id: '',
                    title: '',
                    author:
                        {
                            name: ''
                        },
                    genre:
                        {
                            name: ''
                        }
                },
            });
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
            <div className="App">
                <h1>Library</h1>
                <Button className="my-3" color="primary" onClick={this.toggleNewBookModel.bind(this)}>Add a
                    book</Button>

                <Modal isOpen={this.state.newBookModel} toggle={this.toggleNewBookModel.bind(this)}
                       className={this.props.className}>
                    <ModalHeader toggle={this.toggleNewBookModel.bind(this)}>Add a new book</ModalHeader>
                    <ModalBody>
                        <FormGroup>
                            <Input type={"hidden"} name="id" value={this.state.newBookData.id}/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="title">Enter title</Label>
                            <Input type="text" name="title" id="title" value={this.state.newBookData.title}
                                   onChange={(e) => {
                                       let newBookData = this.state.newBookData;
                                       newBookData.title = e.target.value;
                                       this.setState({newBookData});
                                   }}/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="author">Enter author</Label>
                            <Input type="text" name="author.name" id="author" value={this.state.newBookData.author.name}
                                   onChange={(e) => {
                                       let newBookData = this.state.newBookData;
                                       newBookData.author.name = e.target.value;
                                       this.setState({newBookData});
                                   }}/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="genre">Enter genre</Label>
                            <Input type="text" name="genre.name" id="genre" value={this.state.newBookData.genre.name}
                                   onChange={(e) => {
                                       let newBookData = this.state.newBookData;
                                       newBookData.genre.name = e.target.value;
                                       this.setState({newBookData});
                                   }}/>
                        </FormGroup>
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={this.addBook.bind(this)}>Add book</Button>
                        <Button color="secondary" onClick={this.toggleNewBookModel.bind(this)}>Cancel</Button>
                    </ModalFooter>
                </Modal>


                <Modal isOpen={this.state.editBookModel} toggle={this.toggleEditBookModel.bind(this)}
                       className={this.props.className}>
                    <ModalHeader toggle={this.toggleEditBookModel.bind(this)}>Edit book</ModalHeader>
                    <ModalBody>
                        <FormGroup>
                            <Input type={"hidden"} name="id" value={this.state.editBookData.id}/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="title">Enter title</Label>
                            <Input type="text" name="title" id="title" value={this.state.editBookData.title}
                                   onChange={(e) => {
                                       let editBookData = this.state.editBookData;
                                       editBookData.title = e.target.value;
                                       this.setState({editBookData});
                                   }}/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="author">Enter author</Label>
                            <Input type="text" name="author.name" id="author"
                                   value={this.state.editBookData.author.name}
                                   onChange={(e) => {
                                       let editBookData = this.state.editBookData;
                                       editBookData.author.name = e.target.value;
                                       this.setState({editBookData});
                                   }}/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="genre">Enter genre</Label>
                            <Input type="text" name="genre.name" id="genre" value={this.state.editBookData.genre.name}
                                   onChange={(e) => {
                                       let editBookData = this.state.editBookData;
                                       editBookData.genre.name = e.target.value;
                                       this.setState({editBookData});
                                   }}/>
                        </FormGroup>
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={this.editBook.bind(this, this.state.editBookData.id)}>Edit
                            book</Button>
                        <Button color="secondary" onClick={this.toggleEditBookModel.bind(this)}>Cancel</Button>
                    </ModalFooter>
                </Modal>
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
            </div>
        )
    }
}

export default App;
