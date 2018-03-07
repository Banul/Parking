const validateParkingOwner = (inputValue) => {
    return !!inputValue.match(/^\d{4}-\d{2}-\d{2}$/); // had to use double '!!' to convert to boolean
}

export default validateParkingOwner;