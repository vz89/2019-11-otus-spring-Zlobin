import * as React from "react";
import {connect} from "react-redux";
import {withRouter} from "react-router-dom";
import {compose} from "redux";
import {getOneVacation} from "../../redux/vacation-reducer";
import VacationInfoPage from "./VacationInfoPage";


class VacationInfoContainer extends React.Component {
    componentDidMount() {
        let vacationId = this.props.match.params.vacationId;
        this.props.getOneVacation(vacationId);
    }

    render() {
      return <VacationInfoPage
          vacation = {this.props.vacation}
          news = {this.props.news}
      />
    }
}

let mapStateToProps =(state) => {
    return {
        vacation: state.vacationPage.vacation,
        news: state.vacationPage.news,
        weather: state.vacationPage.weather
    }
};


export default compose(connect(mapStateToProps,{getOneVacation}),withRouter)(VacationInfoContainer);