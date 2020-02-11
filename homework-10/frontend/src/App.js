import React, {Component} from 'react';
import {Button, Form, FormGroup, Input, Label, Table} from 'reactstrap';
import axios from "axios";
import Book from "./component/Book"
import {AppStartState} from "./state/AppStartState"
import {Api} from "./api/api";
import CreateBookForm from "./CreateBookForm";

class App extends Component {









    editBook(id) {
        let Id = Number.parseInt(id);
        axios.put('http://localhost:8080/books/' + Id, this.state.editBookData).then((response) => {
            this.setState({
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

    changeFieldHandler = (e) => {
        let newBookData = this.state.newBookData;
        newBookData["title"] = e.target.value;
        this.setState({newBookData});
    };
    changeFieldHandlerAuthor = (e) => {
        let newBookData = this.state.newBookData;
        newBookData["author"]["name"] = e.target.value;
        this.setState({newBookData});
    };
    changeFieldHandlerGenre = (e) => {
        let newBookData = this.state.newBookData;
        newBookData["genre"]["name"] = e.target.value;
        this.setState({newBookData});
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
        return (
            <div className="App">
                <Books/>
            </div>
        )
    }
}
export default App;
