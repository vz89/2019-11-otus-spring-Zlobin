import axios from "axios";

export class BookApi {
    static getBooks() {
        return axios.get('http://localhost:8080/books');
    }

}


