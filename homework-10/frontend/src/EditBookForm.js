import React from 'react'
import {FormGroup, Input, Label, Modal, ModalBody, ModalHeader} from "reactstrap";

export default props => (
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
)