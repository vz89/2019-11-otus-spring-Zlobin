import React from 'react'
import {Button, FormGroup, Input, Label, Modal, ModalBody, ModalFooter, ModalHeader} from "reactstrap";

export default props => (
    <Modal isOpen={props.editBookForm} toggle={props.toggleEditBookModel}
    >
        <ModalHeader toggle={props.toggleEditBookModel}>Edit book</ModalHeader>
        <ModalBody>
            <FormGroup>
                <Input type={"hidden"} name="id" value={props.id}/>
            </FormGroup>
            <FormGroup>
                <Label for="title">Enter title</Label>
                <Input type="text" name="title" id="title" value={props.title}
                       onChange={(e) => props.changeTitleFieldHandler("editBookData", "title", e)}/>
            </FormGroup>
            <FormGroup>
                <Label for="author">Enter author</Label>
                <Input type="text" name="authorName" id="author"
                       value={props.authorName}
                       onChange={(e) => props.changeAuthorGenreFieldHandler("editBookData", "author", "name", e)}/>
            </FormGroup>
            <FormGroup>
                <Label for="genre">Enter genre</Label>
                <Input type="text" name="genreName" id="genre" value={props.genreName}
                       onChange={(e) => props.changeAuthorGenreFieldHandler("editBookData", "genre", "name", e)}/>
            </FormGroup>
        </ModalBody>
        <ModalFooter>
            <Button color="primary" onClick={props.editBook}>Edit
                book</Button>
            <Button color="secondary" onClick={props.toggleEditBookModel}>Cancel</Button>
        </ModalFooter>
    </Modal>
)