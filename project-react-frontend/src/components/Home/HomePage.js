import React from "react";
import VacationCard from "./VacationCard/VacationCard";
import {CardDeck} from "react-bootstrap";


const HomePage = (props) => {
    let vacationsElements = props.vacations.map(({id, title, description, country, city, startDate, endDate, username}) =>
         <VacationCard
            id={id}
            title={title}
            description={description}
            country={country}
            city={city}
            startDate={startDate}
            endDate={endDate}
            username={username}
        />
    );

    return (
        <div className='text-center'>
            <h1 className={"display-1"}>Public vacations</h1>
            <CardDeck>
                {vacationsElements}
            </CardDeck>
        </div>
    )
};

export default HomePage;