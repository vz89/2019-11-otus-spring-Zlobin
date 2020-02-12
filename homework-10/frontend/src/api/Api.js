import axios from "axios";

export class Api {
    static getBooks() {
        return axios.get('http://localhost:8080/books');
    }

    static deleteBook(id) {
        return axios.delete('http://localhost:8080/books/' + id);
    }

    static addBook(bookData) {
        return axios.post('http://localhost:8080/books', bookData);
    }

    static editBook(id, bookData) {
        return axios.put('http://localhost:8080/books/' + id, bookData);
    }

    static getBook(id) {
        return axios.get('http://localhost:8080/books/' + id);
    }

    static addComment(commentData) {
        return axios.post('http://localhost:8080/comment/', commentData)
    }

    static deleteComment(id) {
        return axios.delete('http://localhost:8080/comment/' + id);
    }
}


