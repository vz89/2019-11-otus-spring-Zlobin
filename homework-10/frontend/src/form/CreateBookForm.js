import React from 'react'
import {Button, Form, FormGroup, Input, Label} from "reactstrap";

export default props => (
    <Form inline={true}>
        <Input type="hidden" name="id" value={props.id}/>
        <FormGroup>
            <Label>
                Title:
                <Input type="text" name="title" value={props.title}
                       onChange={(e) => props.changeTitleFieldHandler("newBookData", "title", e)}
                />
            </Label>
        </FormGroup>
        <FormGroup>
            <Label>
                Author:
                <Input type="text" name="authorname" value={props.authorName}
                       onChange={(e) => props.changeAuthorGenreFieldHandler("newBookData", "author", "name", e)}
                />
            </Label>
        </FormGroup>
        <FormGroup>
            <Label>
                Genre:
                <Input type="text" name="genrename" value={props.genreName}
                       onChange={(e) => props.changeAuthorGenreFieldHandler("newBookData", "genre", "name", e)}
                />
            </Label>
        </FormGroup>
        <FormGroup>
            <Button onClick={props.addBook}>{props.buttonLabel}</Button>
        </FormGroup>
    </Form>
)