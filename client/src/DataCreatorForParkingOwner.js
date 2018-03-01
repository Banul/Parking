import React from "react";

const DataCreatorForParkingOwner = (props) => {
    let divToReturn = <div> </div>;
    
    if (props.requestStatus !== 200  & props.buttonClicked === true){
        divToReturn = <div> Connection error </div>
    }

   else if (props.checkedDate !== undefined & props.buttonClicked){
            const styleSuccess = {
               margin: "20px",
               color: "#006603"
             }
        divToReturn = <div style = {styleSuccess}>
                <p> Checked date: {props.checkedDate} </p>
                <p> Total income: {props.income} </p>
            </div>
    }
    else if (props.buttonClicked & props.income === undefined){
        divToReturn = <div>This date does not exist in database</div>
    }
    return divToReturn;

}

export default DataCreatorForParkingOwner;
