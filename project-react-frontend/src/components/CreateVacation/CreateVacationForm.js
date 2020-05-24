import {Field} from "redux-form";
import React from "react";
import Autocomplete from  'react-autocomplete';

const CreateVacationForm = (props) => {
    let getCountry =()=> {
        return [
            {name: 'Afghanistan', code: 'AF'},{name: 'Åland Islands', code: 'AX'},{name: 'Albania', code: 'AL'},{name: 'Algeria', code: 'DZ'},{name: 'American Samoa', code: 'AS'},{name: 'AndorrA', code: 'AD'},{name: 'Angola', code: 'AO'}, {name: 'Anguilla', code: 'AI'},{name: 'Antarctica', code: 'AQ'},{name: 'Antigua and Barbuda', code: 'AG'},{name: 'Argentina', code: 'AR'}, {name: 'Armenia', code: 'AM'},{name: 'Aruba', code: 'AW'}, {name: 'Australia', code: 'AU'},{name: 'Austria', code: 'AT'},{name: 'Azerbaijan', code: 'AZ'},{name: 'Bahamas', code: 'BS'}, {name: 'Bahrain', code: 'BH'},{name: 'Bangladesh', code: 'BD'}, {name: 'Barbados', code: 'BB'},{name: 'Belarus', code: 'BY'}, {name: 'Belgium', code: 'BE'}, {name: 'Belize', code: 'BZ'}, {name: 'Benin', code: 'BJ'}, {name: 'Bermuda', code: 'BM'},{name: 'Bhutan', code: 'BT'},{name: 'Bolivia', code: 'BO'},{name: 'Bosnia and Herzegovina', code: 'BA'},   {name: 'Botswana', code: 'BW'},   {name: 'Bouvet Island', code: 'BV'},   {name: 'Brazil', code: 'BR'},   {name: 'British Indian Ocean Territory', code: 'IO'},   {name: 'Brunei Darussalam', code: 'BN'},   {name: 'Bulgaria', code: 'BG'},   {name: 'Burkina Faso', code: 'BF'},   {name: 'Burundi', code: 'BI'},   {name: 'Cambodia', code: 'KH'},   {name: 'Cameroon', code: 'CM'},   {name: 'Canada', code: 'CA'},   {name: 'Cape Verde', code: 'CV'},{name: 'Cayman Islands', code: 'KY'},   {name: 'Central African Republic', code: 'CF'},   {name: 'Chad', code: 'TD'}]
    };
    let matchCountry =(state, value) => {
        console.log(state);
        console.log(value);
        return (
            state.name.toLowerCase().indexOf(value.toLowerCase()) !== -1 ||
            state.code.toLowerCase().indexOf(value.toLowerCase()) !== -1
        );
    };

    return <form onSubmit={props.handleSubmit}>
        <div className={"form-group"}>
            <label htmlFor="title">Title</label>
            <Field className={"form-control col-md-6"} required component={"input"} name={"title"} />
        </div>
        <div className={"form-group"}>
            <label htmlFor="description">Description </label>
            <Field className={"form-control col-md-6"} required component={"input"} name={"description"} />
        </div>
        <div className={"form-group"}>
            <label htmlFor="country">Country </label>
            <Field className={"form-control col-md-6"} required component={"input"} name={"country"} />
        </div>
        <div className={"form-group"}>
            <label htmlFor="city">City</label>
            <Field className={"form-control col-md-6"} required component={"input"} name={"city"} />
        </div>
        <div className={"form-group"}>
            <label htmlFor="startDate">StartDate </label>
            <Field className={"form-control col-md-6"} required type={"date"} component={"input"} name={"startDate"} />
        </div>
        <div className={"form-group"}>
            <label htmlFor="endDate">End Date </label>
            <Field className={"form-control col-md-6"} required type={"date"} component={"input"} name={"endDate"} />
        </div>
        <div>
            <button  className="btn btn-primary mb-2">Create Vacation</button>
        </div>
    </form>
};

export default CreateVacationForm;