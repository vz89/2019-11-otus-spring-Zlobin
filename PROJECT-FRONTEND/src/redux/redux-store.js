import {applyMiddleware, combineReducers, createStore} from "redux";
import thunkMiddleware from "redux-thunk";
import homeReducer from "./home-reducer";
import authReducer from "./auth-reducer";
import {reducer as formReducer} from 'redux-form';
import vacationReducer from "./vacation-reducer";
import createVacationReducer from "./create-vacation-reducer";

let reducers = combineReducers({
    homePage: homeReducer,
    auth: authReducer,
    vacationPage: vacationReducer,
    createVacationPage: createVacationReducer,
    form: formReducer
});

let store = createStore(reducers, applyMiddleware(thunkMiddleware));
export default store;