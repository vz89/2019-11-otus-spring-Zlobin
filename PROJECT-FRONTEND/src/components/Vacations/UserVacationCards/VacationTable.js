import React from "react";
import VacationRow from "./VacationRow";

const VacationTable = (props) => {
    let vacationsElements = props.vacations
        .sort((prev, next) =>
            prev.daysLeft - next.daysLeft)
        .map((vacation, index) => {
            return (
                <VacationRow
                    id={vacation.id}
                    index={index}
                    title={vacation.title}
                    description={vacation.description}
                    country={vacation.country}
                    city={vacation.city}
                    daysLeft={vacation.daysLeft >= 0 ? vacation.daysLeft : "в архиве"}
                    startDate={vacation.startDate}
                    endDate={vacation.endDate}
                    deleteVacation = {()=>props.deleteVacation(vacation.id)}
                />
            )
        });
    return <div>
        <table className={"table mt-2"}>
            <thead className={".thead-light"}>
            <tr>
                <th>#</th>
                <th>Title</th>
                <th>Description</th>
                <th>Country</th>
                <th>City</th>
                <th>Days left</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            {vacationsElements}
            </tbody>
        </table>
    </div>
};


export default VacationTable;