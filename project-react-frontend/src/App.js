import React from 'react';
import './App.css';
import HomePageContainer from "./components/Home/HomePageContainer";
import {Route} from "react-router-dom";
import Login from "./components/Login/Login";
import HeaderContainer from "./components/Header/HeaderContainer";
import VacationPageContainer from "./components/Vacations/VacationPageContainer";
import NewsContainer from "./components/News/NewsContainer";
import MessagesContainer from "./components/Messages/MessagesContainer";
import Registration from "./components/Registration/Registration";
import CreateVacation from "./components/CreateVacation/CreateVacation";
import VacationInfoContainer from "./components/Vacation/VacationInfoContainer";

function App() {
    return (
        <div>
            <HeaderContainer/>
            <div className='container mt-2'>
                <Route exact path="/" render={() => <HomePageContainer/>}/>
                <Route exact path="/login" render={() => <Login/>}/>
                <Route exact path="/vacations" render={() => <VacationPageContainer/>}/>
                <Route exact path="/news" render={() => <NewsContainer/>}/>
                <Route exact path="/messages" render={() => <MessagesContainer/>}/>
                <Route exact path="/registration" render={() => <Registration/>}/>
                <Route exact path="/create-vacation" render={() => <CreateVacation/>}/>
                <Route exact path="/vacation/:vacationId?"
                       render={() => <VacationInfoContainer/>}/>
            </div>
        </div>
    );
}

export default App;