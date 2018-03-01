import React from "react";
import './button.css';

const DataCreatorForDriver = (props) => {

     let divToReturn = <div></div>;

         if (props.requestStatus !== 200 & props.buttonClicked === true){
            divToReturn = <div> Connection error </div>
        }

        else if (props.price !== undefined & props.buttonClicked){
            let informationAboutMeterStatus;

            if (props.isMeterActive === 'false'){
                informationAboutMeterStatus = "Meter is running";
            }

            else{
                informationAboutMeterStatus = "Meter is not running";
            }

            const styleSuccess = {
               margin: "20px",
               color: "#006603"
             }
            divToReturn =  <div style = {styleSuccess}> 
               <p> Checked PESEL : {props.chosenPesel} </p>
               <p> Price : {props.price} </p>
               <p> Meter status : {informationAboutMeterStatus} </p>
            <button type="button" disabled = {props.isMeterActive} className="button btn btn-success">Start meter</button>
            <button type="button" disabled = {!props.isMeterActive} className="button btn btn-danger">Stop meter</button>



            </div>
        }
        else if (props.buttonClicked & props.price === undefined){
            const styleError = {
                margin: "20px",
                color: "#670003"
            }
            divToReturn = <div style = {styleError}> Driver with entered PESEL does not exist </div>
        }

        
        return divToReturn

}

export default DataCreatorForDriver;
