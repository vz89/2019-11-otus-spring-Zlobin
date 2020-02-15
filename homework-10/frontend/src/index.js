import React from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import {BrowserRouter, Route} from "react-router-dom";
import BookPage from "./bookPage/BookPage";

const app = (<BrowserRouter>
    <Route exact path="/" component={App}/>
    <Route path="/book/:id" component={BookPage}/>
</BrowserRouter>)


ReactDOM.render(app, document.getElementById('root'));
serviceWorker.unregister();
