import React from "react";
import '../styles/button.css';
import '../styles/errorAndSuccesStyles.css';


const DataCreatorForDriver = (props) => {

    let divToReturn = <div></div>;

    if (!props.errorGet & props.buttonClicked & props.showDataAboutCurrentMeterStatus){            
            let informationAboutMeterStatus;
            if (props.isMeterActive === false){
                informationAboutMeterStatus = "Meter is not running";
            } else{
                informationAboutMeterStatus = "Meter is running";
            }
           
            divToReturn =  <div className = "styleSuccess"> 
               <p> Checked PESEL : {props.chosenPesel} </p>
               <p> Price : {props.price} {props.currency}</p>
               <p> Meter status : {informationAboutMeterStatus} </p>
            <button type="button" disabled = {props.isMeterActive} onClick = {() => props.onMeterButtonClicked("start")} className="button btn btn-success">Start meter</button>
            <button type="button" disabled = {!props.isMeterActive} onClick = {() => props.onMeterButtonClicked("stop")} className="button btn btn-danger">Stop meter</button>
         </div>

        } else if (props.errorGet & props.buttonClicked === true & props.showDataAboutCurrentMeterStatus){
            divToReturn = <div> error </div>
        } else if (props.putStatus === 200  & props.showDataAboutSuccessfullPut === true){
            divToReturn = <div className = "styleSuccess"> Data sucessfully put </div> 
        } else if (props.putStatus === 404 & !props.showDataAboutSuccessfullPut){
            divToReturn = <div className = "styleSuccess"> Error while putting data </div>
        }

        
        return divToReturn

}

export default DataCreatorForDriver;
