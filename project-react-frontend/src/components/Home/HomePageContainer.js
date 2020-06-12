import React from "react";
import {connect} from "react-redux";
import {getPublicVacations} from "../../redux/home-reducer";
import HomePage from "./HomePage";


class HomePageContainer extends React.Component {

    componentDidMount() {
        this.props.getPublicVacations();
    }

    render() {
        return (
            <HomePage
                vacations = {this.props.vacations}
            />
        )
    }
}

let mapStateToProps = (state) => {
    return {
        vacations: state.homePage.vacations
    }
};

export default connect(mapStateToProps, {
    getPublicVacations
})(HomePageContainer);