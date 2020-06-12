import React from "react";
import {connect} from "react-redux";
import VacationPage from "./VacationPage";
import {deleteOneVacation, getVacations} from "../../redux/vacation-reducer";


class VacationPageContainer extends React.Component {

    componentDidMount() {
        this.props.getVacations();
    }
    deleteVacation (id){
        this.props.deleteOneVacation(id);
    };

    render() {
        return (
            <VacationPage
                vacations={this.props.vacations}
                deleteVacation = {this.deleteVacation.bind(this)}
            />
        )
    }
}

let mapStateToProps = (state) => {
    return {
        vacations: state.vacationPage.userVacations
    }
};

export default connect(mapStateToProps, {
    getVacations,deleteOneVacation
})(VacationPageContainer);