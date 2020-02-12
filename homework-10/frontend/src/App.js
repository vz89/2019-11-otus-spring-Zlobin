import React, {Component} from 'react';
import {Table} from 'reactstrap';
import Book from "./component/Book"
import {AppStartState} from "./state/AppStartState"
import {Api} from "./api/Api";
import CreateBookForm from "./form/CreateBookForm";
import EditBookForm from "./form/EditBookForm";

class App extends Component {
    state = AppStartState;

    componentDidMount() {
        Api.getBooks().then((response) => {
            this.setState({
                books: response.data
            })
        });
    }

    deleteBook(id) {
        let Id = Number.parseInt(id);
        Api.deleteBook(Id).then(() => {
            this.componentDidMount();
        });
    }

    addBook() {
        Api.addBook(this.state.newBookData).then(() => {
            this.setState({
                newBookData: AppStartState.newBookData
            });
            this.componentDidMount();
        });
    }

    editBook(id) {
        let Id = Number.parseInt(id);
        Api.editBook(Id, this.state.editBookData).then(() => {
            this.setState({
                editBookData: AppStartState.editBookData,
                editBookForm: !this.state.editBookForm
            });
            this.componentDidMount();
        });
    }

    changeTitleFieldHandler = (datatype, title, e) => {
        switch (datatype) {
            case "newBookData": {
                let newBookData = this.state.newBookData;
                newBookData[title] = e.target.value;
                this.setState({newBookData});
                break;
            }
            case "editBookData": {
                let editBookData = this.state.editBookData;
                editBookData[title] = e.target.value;
                this.setState({editBookData});
                break;
            }
        }
    };

    changeAuthorGenreFieldHandler = (datatype, prop, name, e) => {
        switch (datatype) {
            case "newBookData": {
                let newBookData = this.state.newBookData;
                newBookData[prop][name] = e.target.value;
                this.setState({newBookData});
                break;
            }
            case "editBookData": {
                let editBookData = this.state.editBookData;
                editBookData[prop][name] = e.target.value;
                this.setState({editBookData});
                break;
            }

        }
    };

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
            editBookForm: !this.state.editBookForm
        })
    }

    render() {
        const books = this.state.books.map((book, index) => {
            return (
                <Book
                    id={book.id}
                    index={index}
                    title={book.title}
                    authorname={book.author.name}
                    genrename={book.genre.name}
                    editBook={this.toggleEditBookModel.bind(this, book.id, book.title, book.author.name, book.genre.name)}
                    deleteBook={this.deleteBook.bind(this, book.id)}
                />
            )
        });
        return (
            <div className="App m-3">
                <h1>Library</h1>
                <div className={"m-3"}>
                    <CreateBookForm
                        id=""
                        title={this.state.newBookData.title}
                        authorName={this.state.newBookData.author.name}
                        genreName={this.state.newBookData.genre.name}
                        changeTitleFieldHandler={this.changeTitleFieldHandler.bind(this)}
                        changeAuthorGenreFieldHandler={this.changeAuthorGenreFieldHandler.bind(this)}
                        addBook={this.addBook.bind(this)}
                        buttonLabel="Create Book"
                    />
                </div>
                <EditBookForm
                    editBookForm={this.state.editBookForm}
                    toggleEditBookModel={this.toggleEditBookModel.bind(this)}
                    changeTitleFieldHandler={this.changeTitleFieldHandler.bind(this)}
                    changeAuthorGenreFieldHandler={this.changeAuthorGenreFieldHandler.bind(this)}
                    id={this.state.editBookData.id}
                    title={this.state.editBookData.title}
                    authorName={this.state.editBookData.author.name}
                    genreName={this.state.editBookData.genre.name}
                    editBook={this.editBook.bind(this, this.state.editBookData.id)}
                />
                <div>
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
            </div>

        )
    }
}

export default App;
