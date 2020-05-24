import * as React from "react";
import Header from "./Header";
import {connect} from "react-redux";
import {getAuth, logout} from "../../redux/auth-reducer";

class HeaderContainer extends React.Component {
    componentDidMount() {
        if (!this.props.auth && localStorage.getItem("hv-token") != null)
            debugger
        this.props.getAuth();
    }

    render() {
        return (
            <Header
                username={this.props.auth.username}
                isAuth={this.props.auth.isAuth}
                logout={this.props.logout}
            />
        );
    }
}

let mapStateToProps = (state) => {
    return {
        auth: state.auth
    }
};

export default connect(mapStateToProps, {logout, getAuth})(HeaderContainer);