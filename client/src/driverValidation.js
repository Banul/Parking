import React from "react";

const driverValidation = (inputValue) =>{
    const inputLength = inputValue.length;
    const inputValueLower = inputValue.toLowerCase();
    if ((inputLength !== 4 || !inputValueLower.match(/^[0-9]+$/))){
        return false;
    }
    else{
        return true;
    }
}

export default driverValidation;