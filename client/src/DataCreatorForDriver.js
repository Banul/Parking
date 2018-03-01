import React from "react"

const DataCreatorForDriver = (props) => {

     let divToReturn = <div>ooo</div>;

         if (props.requestStatus !== 200 & props.buttonClicked === true){
            divToReturn = <div> Connection error </div>
        }

        else if (props.price !== undefined & props.buttonClicked){
            console.log("aaa");
            const styleSuccess = {
               margin: "20px",
               color: "#006603"
             }
            divToReturn =  <div style = {styleSuccess}> 
               <p> Checked PESEL : {props.chosenPesel} </p>
               <p> Price : {props.price} </p>

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
