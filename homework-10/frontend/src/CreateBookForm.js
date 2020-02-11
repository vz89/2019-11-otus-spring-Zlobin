import React from 'react'
import {Button, Form, FormGroup, Input, Label} from "reactstrap";

export default props => (
    <Form inline={true} className={""}>
        <Input type="hidden" name = "id" value ={props.id}/>
        <FormGroup>
            <Label>
                Title:
                <Input type="text" name="title" value={props.title}
                       onChange={props.changeFieldHandler}
                />
            </Label>
        </FormGroup>
        <FormGroup>
            <Label>
                Author:
                <Input type="text" name="authorName" value={props.authorName}
                       onChange={props.changeFieldHandlerAuthor}
                />
            </Label>
        </FormGroup>
        <FormGroup>
            <Label>
                Genre:
                <Input type="text" name="genreName" value={props.genreName}
                       onChange={props.changeFieldHandlerGenre}
                />
            </Label>
        </FormGroup>
        <FormGroup>
            <Button onClick={props.addBook}>{props.buttonLabel}</Button>
        </FormGroup>
    </Form>
)