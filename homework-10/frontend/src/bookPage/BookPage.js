import React from 'react';
import {Button, Form, FormGroup, Input, Label, Table} from "reactstrap";
import {BookPageStartState} from "../state/BookPageStartState";
import Comment from "../component/Comment";
import {Link} from "react-router-dom";
import {Api} from "../api/Api";

class BookPage extends React.Component {
    state = BookPageStartState;

    componentDidMount() {
        Api.getBook(this.props.match.params.id).then((response) => {
            this.setState({
                book: response.data.book,
                comments: response.data.comments
            })
        });
    };

    deleteComment(id) {
        let Id = Number.parseInt(id);
        Api.deleteComment(Id).then(() => {
            this.componentDidMount();
        })
    };

    addComment() {
        Api.addComment(this.state.newComment).then((response) => {
            console.log(response);
            this.setState({
                newComment: {
                    text: '',
                    book: {id: this.props.match.params.id}
                }
            });
            this.componentDidMount();
        });
    }

    render() {
        let comments = this.state.comments.map((comment, index) => {
            return (
                <Comment
                    id={comment.id}
                    index={index}
                    text={comment.text}
                    deleteComment={this.deleteComment.bind(this, comment.id)}
                />
            )
        });
        return (
            <div className={"my-2"}>
                <h2>Title: {this.state.book.title}</h2>
                <h2>Author: {this.state.book.author.name}</h2>
                <h2>Genre: {this.state.book.genre.name}</h2>
                <h3 color="blue">Comments:</h3>
                <Link to={'/'}>Back to Library</Link>
                <Table>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Text</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {comments}
                    </tbody>
                </Table>
                <Form>
                    <FormGroup>
                        <Label>
                            Text:
                            <Input type="textarea" name="text" value={this.state.newComment.text}
                                   onChange={(e) => {
                                       let newComment = this.state.newComment;
                                       newComment.text = e.target.value;
                                       newComment.book.id = this.props.match.params.id;
                                       this.setState({newComment});
                                   }}
                            />
                        </Label>
                    </FormGroup>
                    <FormGroup>
                        <Button onClick={this.addComment.bind(this)}>Add comment</Button>
                    </FormGroup>
                </Form>
            </div>
        )
    }
}

export default BookPage