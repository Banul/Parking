const validateParkingOwner = (inputValue) => {
    if (!inputValue.match(/^\d{4}-\d{2}-\d{2}$/)){
        return false;
    }

    else{
        return true;
    }
}

export default validateParkingOwner;