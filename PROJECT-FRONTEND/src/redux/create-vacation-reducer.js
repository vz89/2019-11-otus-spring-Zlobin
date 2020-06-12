import {vacationApi} from "../api/api";

const REDIRECT_TO_PAGE = "REDIRECT_TO_PAGE";

let initialState = {
    redirectToNewPage:false
};

const createVacationReducer = (state = initialState, action) => {
    switch (action.type) {
        case REDIRECT_TO_PAGE:
            return {
                ...state,
                redirectToNewPage: action.redirectToNewPage
            };
        default:
            return state;
    }
};

export const setRedirectToPage = (redirectToNewPage)=>({type:REDIRECT_TO_PAGE,redirectToNewPage});

export const createNewVacation = (formData,redirectToNewPage) => (dispatch) => {
    vacationApi.createVacation(formData).then(response =>{
        if (response.status === 201) dispatch(setRedirectToPage(redirectToNewPage));
    })
};


export default createVacationReducer;
