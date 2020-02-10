import React from 'react'
import {Button, FormGroup, Input, Label, Modal, ModalBody, ModalFooter, ModalHeader} from "reactstrap";
import axios from "axios";


export class NewBookModel extends React.Component {
    state = {
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
        }
    };
    render() {
        return (
            <Modal isOpen={this.props.newBookModel} toggle={this.props.toggleNewBookModel}
                   className={this.props.className}>
                <ModalHeader toggle={this.props.toggleNewBookModel}>Add a new book</ModalHeader>
                <ModalBody>
                    <FormGroup>
                        <Input type={"hidden"} name="id" value={this.props.newBookData.id}/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="title">Enter title</Label>
                        <Input type="text" name="title" id="title" value={this.props.newBookData.title}
                               onChange={(e) => {
                                   let newBookData = this.props.newBookData;
                                   newBookData.title = e.target.value;
                                   this.setState({newBookData});
                               }}/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="author">Enter author</Label>
                        <Input type="text" name="author.name" id="author" value={this.props.newBookData.author.name}
                               onChange={(e) => {
                                   let newBookData = this.props.newBookData;
                                   newBookData.author.name = e.target.value;
                                   this.setState({newBookData});
                               }}/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="genre">Enter genre</Label>
                        <Input type="text" name="genre.name" id="genre" value={this.props.newBookData.genre.name}
                               onChange={(e) => {
                                   let newBookData = this.state.newBookData;
                                   newBookData.genre.name = e.target.value;
                                   this.setState({newBookData});
                               }}/>
                    </FormGroup>
                </ModalBody>
                <ModalFooter>
                    <Button color="primary" >Add book</Button>
                    <Button color="secondary" onClick={this.props.toggleNewBookModel}>Cancel</Button>
                </ModalFooter>
            </Modal>
        )
    }
}

