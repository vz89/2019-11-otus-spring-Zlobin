import React from "react";
import {Field} from "redux-form";

const LoginForm = (props) => {
    return <form onSubmit={props.handleSubmit}>
        <div className={"form-group"}>
            <label htmlFor="username">User Name </label>
            <Field className={"form-control col-md-6"} component={"input"} name={"username"} placeholder={"username"}/>
        </div>
        <div className={"form-group"}>
            <label htmlFor="password">Password </label>
            <Field className={"form-control col-md-6"} component={"input"} type={"password"} name={"password"} placeholder={"password"}/>
        </div>
        <div>
            <button  className="btn btn-primary mb-2">Login</button>
        </div>

    </form>
};

export default LoginForm;