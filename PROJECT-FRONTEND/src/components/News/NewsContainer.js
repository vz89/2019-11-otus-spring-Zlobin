import * as React from "react";
import {connect} from "react-redux";


class NewsContainer extends React.Component {

    render() {
        return (
            <div>Страница в разработке</div>
        )
    }
}

let mapStateToProps = (props) => {
    return props.state;
};


export default connect(mapStateToProps, null)(NewsContainer);

