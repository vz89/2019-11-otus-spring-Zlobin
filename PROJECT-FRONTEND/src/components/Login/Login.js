import {reduxForm} from "redux-form";
import LoginForm from "./LoginForm";
import React from "react";
import {connect} from "react-redux";
import {loginUser} from "../../redux/auth-reducer";
import {Redirect} from "react-router-dom";


const LoginReduxForm = reduxForm({
    form: 'login'
})(LoginForm);

const Login = (props) => {
    let onSubmit = (formData) => {
        props.loginUser(formData.username, formData.password)
    };

    if (props.isAuth) {
        return <Redirect to={"/vacations"}/>
    }
    return <div>
        <h1>Login</h1>
        <LoginReduxForm onSubmit={onSubmit}/>
    </div>
};

let mapStateToProps = (state) => {
    return {
        isAuth: state.auth.isAuth
    }
};
export default connect(mapStateToProps, {
    loginUser
})(Login);

