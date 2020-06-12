import {vacationApi} from "../api/api";

const SET_VACATIONS = "SET_VACATIONS";



let initialState = {
    vacations: []
};


const homeReducer = (state = initialState, action) => {
    switch (action.type) {
        case SET_VACATIONS:
            return {
                ...state,
                vacations: [...action.vacations]
            };
        default:
            return state;
    }

};

export const setVacations = (vacations) => ({type: SET_VACATIONS, vacations});

export const getPublicVacations = () => (dispatch) => {
    vacationApi.getPublicVacations().then(response => {
        dispatch(setVacations(response.data));
    });
};

export default homeReducer;