import React from "react";
import './button.css';

 const styleSuccess = {
               margin: "20px",
               color: "#006603"
             }

const styleError = {
                margin: "20px",
                color: "#670003"
            }

const DataCreatorForDriver = (props) => {

     let divToReturn = <div></div>;

         if (props.requestStatus !== 200 & props.buttonClicked === true & props.showPanelToGetData){
            divToReturn = <div> Connection error </div>
        }

        else if (props.price !== undefined & props.buttonClicked & props.showPanelToGetData){            
            let informationAboutMeterStatus;

            if (props.isMeterActive === false){
                informationAboutMeterStatus = "Meter is not running";
            }

            else{
                informationAboutMeterStatus = "Meter is running";
            }
           
            divToReturn =  <div style = {styleSuccess}> 
               <p> Checked PESEL : {props.chosenPesel} </p>
               <p> Price : {props.price} </p>
               <p> Meter status : {informationAboutMeterStatus} </p>
            <button type="button" disabled = {props.isMeterActive} onClick = {() => props.onMeterButtonClicked("Start")} className="button btn btn-success">Start meter</button>
            <button type="button" disabled = {!props.isMeterActive} onClick = {() => props.onMeterButtonClicked("Stop")} className="button btn btn-danger">Stop meter</button>
         </div>

        }
        else if (props.buttonClicked & props.price === undefined & props.showPanelToGetData){
            divToReturn = <div style = {styleError}> Driver with entered PESEL does not exist </div>
        }

        else if (props.putStatus === 200  & !props.showPanelToGetData){
            console.log("asudasiu");
            divToReturn = <div style = {styleSuccess}> Data sucesfully put </div> 
        }

        else if (props.putStatus === 404 & !props.showPanelToGetData){
            divToReturn = <div style = {styleError}> Error while putting data </div>
        }

        
        return divToReturn

}

export default DataCreatorForDriver;
