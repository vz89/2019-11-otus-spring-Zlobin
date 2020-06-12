import {vacationApi} from "../api/api";

const SET_USER_VACATIONS = "SET_USER_VACATIONS";
const SET_VACATION_AND_NEWS = "SET_VACATION_AND_NEWS";
const DELETE_VACATION_BY_ID = "DELETE_VACATION_BY_ID";

let initialState = {
    userVacations: [],
    vacation: {},
    news: [],
    weather: []
};


const vacationReducer = (state = initialState, action) => {
    switch (action.type) {
        case SET_USER_VACATIONS:
            return {
                ...state,
                userVacations: [...action.vacations]
            };
        case SET_VACATION_AND_NEWS:
            return {
                ...state,
                vacation: action.vacation,
                news: [...action.news]
            };
        case  DELETE_VACATION_BY_ID:
            return {
                ...state,
                userVacations: [...state.userVacations.filter(value => value.id!==action.id)]
            };
        default:
            return state;
    }
};

export const setUserVacations = (vacations) => ({type: SET_USER_VACATIONS, vacations});
export const setVacationAndNews = (vacation, news) => ({
    type: SET_VACATION_AND_NEWS,
    vacation: vacation,
    news: news
});
export const deleteVacationById = (id) => ({type:DELETE_VACATION_BY_ID, id})

export const getVacations = () => (dispatch) => {
    vacationApi.getVacations().then(response => {
        if (response.status !== 404)
            dispatch(setUserVacations(response.data));
        else dispatch(setUserVacations([]))
    });
};

export const getOneVacation = (id) => (dispatch) => {
    vacationApi.getVacation(id).then(response => {
        if (response.status === 200)
            dispatch(setVacationAndNews(response.data.vacation, response.data.news.articles))
    })
};

export const deleteOneVacation = (id) => (dispatch) => {
    vacationApi.deleteVacation(id).then(response => {
        if (response.status === 200)
            dispatch(deleteVacationById(id))
    })
};


export default vacationReducer;