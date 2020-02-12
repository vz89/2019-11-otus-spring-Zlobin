import React, {Component} from 'react';
import {Table} from 'reactstrap';
import Book from "./component/Book"
import {AppStartState} from "./state/AppStartState"
import {Api} from "./api/Api";
import CreateBookForm from "./form/CreateBookForm";
import EditBookForm from "./form/EditBookForm";

class App extends Component {









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
        return (
            <div className="App">
                <Books/>
            </div>
        )
    }
}

export default App;
