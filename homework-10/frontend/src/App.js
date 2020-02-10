import React, {Component} from 'react';
import {Button, FormGroup, Input, Label, Modal, ModalBody, ModalFooter, ModalHeader, Table} from 'reactstrap';
import axios from "axios";
import {startState} from './startAppState.js';
import {Link} from "react-router-dom";
import {BookApi} from "./api/api.js";
import {Books} from "./component/books.js"

class App extends Component {









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
        return (
            <div className="App">
                <Books/>
            </div>
        )
    }
}

export default App;
