import React from "react";
import VacationTable from "./UserVacationCards/VacationTable";
import {NavLink} from "react-router-dom";


const VacationPage = (props) => {

    return (<>
            <NavLink className={"btn btn-primary"} to={'/create-vacation/'}>Create new vacation</NavLink>
            <VacationTable
                vacations={props.vacations}
                deleteVacation = {props.deleteVacation}
            />
        </>
    )
};

export default VacationPage;