import React from "react";
import '../styles/errorAndSuccesStyles.css';
import {CURRENCY_PLN} from '../constants/ConstansValues';

const DataCreatorForParkingOwner = (props) => {
    let divToReturn = <div> </div>;
    
    if (props.requestStatus !== 200  & props.buttonClicked === true){
        divToReturn = <div> Connection error </div>
    }

   else if (props.checkedDate !== undefined & props.buttonClicked){

        divToReturn = <div className = "styleSuccess">
                <p> Checked date: {props.checkedDate} </p>
                <p> Total income: {props.income} {CURRENCY_PLN}</p>
            </div>
    }

    else if (props.buttonClicked & props.income === undefined){
        divToReturn = <div>This date does not exist in database</div>
    }

    return divToReturn;
}

export default DataCreatorForParkingOwner;
