import React from "react";

const driverAndParkingOperatorValidation = (inputValue, inputMaxLength, role) =>{
    const inputLength = inputValue.length;
    const inputValueLower = inputValue.toLowerCase();
    if (role === "driver"){
      if ((inputLength !== inputMaxLength || !inputValueLower.match(/^[0-9]+$/))){
            return false;
    }
    else{
            return true;
        }
    }
    else if (role === "parking operator"){
           if ((inputLength > inputMaxLength || !inputValueLower.match(/^[0-9]+$/))){
            return false;
    }
    else{
            return true;
        }
    }
}

export default driverAndParkingOperatorValidation;