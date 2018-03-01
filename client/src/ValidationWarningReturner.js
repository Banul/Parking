import React from "react";
import './errorAndSuccesStyles.css';

const ValidationWarningReturner = (props) => {
    console.log("validation returner");
    console.log(props);
    let warning = <div> </div>
    if (props.validationStatus === false){
        warning = <div className = "styleError"> Wrong format </div>
    }
    return warning;
}

export default ValidationWarningReturner;
