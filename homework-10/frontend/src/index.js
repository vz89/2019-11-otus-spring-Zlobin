import React from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import Book from "./book/book";

const app = (<BrowserRouter>
        <Route exact path="/" component={App}/>
        <Route path ="/book/:id" component={Book}/>
</BrowserRouter>)


ReactDOM.render(app, document.getElementById('root'));
serviceWorker.unregister();
