import React from "react";
import '../styles/errorAndSuccesStyles.css';

const ValidationWarningReturner = (props) => {
    let warning = <div> </div>
    if (props.validationStatus === false){
        warning = <div className = "styleError"> Wrong format </div>
    }
    return warning;
}

export default ValidationWarningReturner;
