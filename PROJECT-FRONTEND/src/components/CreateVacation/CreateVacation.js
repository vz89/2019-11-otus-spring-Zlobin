import {reduxForm} from "redux-form";
import React from "react";
import {connect} from "react-redux";
import CreateVacationForm from "./CreateVacationForm";
import {createNewVacation, setRedirectToPage} from "../../redux/create-vacation-reducer";
import {Redirect} from "react-router-dom";


const CreateVacationReduxForm = reduxForm({
    form: 'create-vacation'
})(CreateVacationForm);

const CreateVacation = (props) => {

    let onSubmit = (formData) => {
        props.createNewVacation(formData, true)
    };

    if (props.redirectToPage) {
        props.setRedirectToPage(false);
        return <Redirect to={"/vacations"}/>
    }

    return <div>
        <h1>Enter new vacation</h1>
        <CreateVacationReduxForm onSubmit={onSubmit}/>
    </div>
};
let mapStateToProps = (state) => {
    return {
        redirectToPage: state.createVacationPage.redirectToNewPage
    }
};


export default connect(mapStateToProps, {createNewVacation, setRedirectToPage})(CreateVacation);