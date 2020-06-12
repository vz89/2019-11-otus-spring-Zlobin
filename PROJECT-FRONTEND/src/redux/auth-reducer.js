import {userApi} from "../api/api";

const SET_USER_DATA = 'SET_USER_DATA';
const LOG_OUT_USER = 'LOG_OUT_USER';

let initialState = {
    username: null,
    isAuth: false
};

const authReducer = (state = initialState, action) => {
    switch (action.type) {
        case SET_USER_DATA:
            return {
                ...state,
                username: action.username,
                isAuth: true
            };
        case LOG_OUT_USER:
            return {
                ...state,
                username: null,
                isAuth: false
            };
        default:
            return state;
    }
};

export const setAuthUserData = (username) => ({type: SET_USER_DATA, username: username});
export const logoutUser = () => ({type: LOG_OUT_USER});

export const loginUser = (username, password) => (dispatch) => {
    userApi.login(username, password).then(response => {
        if (response.status === 200) {
            dispatch(setAuthUserData(response.data.username));
            localStorage.setItem("hv-token", response.data.token);
        }
    })
};

export const logout = () => (dispatch) => {
    localStorage.setItem("hv-token", null);
    dispatch(logoutUser());
};

export const getAuth = () => (dispatch) => {
    userApi.getUser().then(response => {
        if (response.status === 200) {
            dispatch(setAuthUserData(response.data));
        }
    })
};

export const registerUser = (username,password) => (dispatch) => {
    userApi.register(username,password).then(response => {
        if (response.status === 201) {
            dispatch(loginUser(username,password))
        }
    })
};


export default authReducer;