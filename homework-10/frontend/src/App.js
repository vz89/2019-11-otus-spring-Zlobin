import React, {Component} from 'react';
import {AppStartState} from "./state/AppStartState"
import CreateBookForm from "./form/CreateBookForm";
import EditBookForm from "./form/EditBookForm";
import {Api} from "./api/Api";
import {BookTable} from "./component/BookTable";
import {EditBookData} from "./state/EditBookData";

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

    toggleEditBookModel = (id, title, authorName, genreName) => {
        this.setState({
            editBookData: EditBookData(id, title, authorName, genreName),
            editBookForm: !this.state.editBookForm
        })
    };

    render() {
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
                    <BookTable
                        books={this.state.books}
                        toggleEditBookModel={this.toggleEditBookModel.bind(this)}
                        deleteBook={this.deleteBook.bind(this)}
                    />
                </div>
            </div>
        )
    }
}

export default App;
