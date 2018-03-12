import React from "react";
import '../styles/errorAndSuccesStyles.css';

const DataCreatorForParkingOwner = (props) => {
    let divToReturn = <div> </div>;
    
    if (props.errorGet !== true  & props.buttonClicked === true){
        divToReturn = <div> error </div>
    } else if (props.errorGet === true & props.buttonClicked){

        divToReturn = <div className = "styleSuccess">
                <p> Checked date: {props.checkedDate} </p>
                <p> Total income: {props.income} {props.currency}</p>
            </div>
    }  
    return divToReturn;
}

export default DataCreatorForParkingOwner;
