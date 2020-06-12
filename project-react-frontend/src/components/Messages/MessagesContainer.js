import * as React from "react";
import {connect} from "react-redux";


class MessagesContainer extends React.Component {
    render() {
        return(
            <div>Страница в разработке</div>
        )
    }
}

let mapStateToProps = (state) => {
    return {
        auth: state.auth
    }
};

export default connect(mapStateToProps,null)(MessagesContainer);