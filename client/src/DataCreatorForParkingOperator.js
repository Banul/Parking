import React from 'react';
import './errorAndSuccesStyles.css';


const DataCreatorForParkingOperator = (props) => {
        let divToReturn = <div></div>;

         if (props.requestStatus !== 200 & props.buttonClicked === true){
            divToReturn = <div> Connection error </div>
        }

        else if (props.currentDriverId !== undefined & props.buttonClicked){

            divToReturn =  <div className = "styleSuccess"> 
               <p> Driver id : {props.currentDriverId} </p>
               <p> Driver's vehicle number : {props.currentDriverVehicleNumber} </p>
               <p> Meter status : {props.parkingMeterStatus} </p>

            </div>
        }

        else if (props.buttonClicked & props.currentDriverId === undefined){
            divToReturn = <div className = "styleError"> Driver with entered id does not exist </div>
        }

        
        return divToReturn

    }

export default DataCreatorForParkingOperator;