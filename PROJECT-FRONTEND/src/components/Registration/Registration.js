import * as React from "react";
import {connect} from "react-redux";
import {reduxForm} from "redux-form";
import RegistrationForm from "./RegistrationForm";
import {Redirect} from "react-router-dom";
import {getAuth, loginUser, registerUser} from "../../redux/auth-reducer";


const RegistrationReduxForm = reduxForm({
    form: 'registration'
})(RegistrationForm);

const Registration = (props) => {
    let onSubmit = (formData) => {
        props.registerUser(formData.username, formData.password)
    };
    if (props.isAuth) {
        return <Redirect to={"/vacations"}/>
    }
    return <div>
        <h1>Register new account</h1>
        <RegistrationReduxForm onSubmit={onSubmit}/>
    </div>


};

let mapStateToProps = (state) => {
    return {
        isAuth: state.auth.isAuth
    }
};

export default connect(mapStateToProps, {registerUser,loginUser}
)(Registration);