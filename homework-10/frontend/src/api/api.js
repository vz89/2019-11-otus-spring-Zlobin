import axios from "axios";

export class Api {
    static getBooks() {
        return axios.get('http://localhost:8080/books');
    }
    static deleteBook(id) {
        return axios.delete('http://localhost:8080/books/' + id);
    }

}


