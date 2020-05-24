import {CardDeck} from "react-bootstrap";
import React from "react";
import VacationNewsCard from "./VacationNews/VacationNewsCard";


const VacationInfoPage = (props) => {
    let newsElements = props.news.map(({title, description, url, urlToImage}) =>
        <VacationNewsCard
            title={title}
            description={description}
            url={url}
            urlToImage={urlToImage}
        />
    );

    return (
        <div>
            <div className='text-center'>
                <h3>News about destination: {props.vacation.country}</h3>
                <div className={"card-columns"}>
                    {newsElements}
                </div>
            </div>
        </div>
    )
};


export default VacationInfoPage;