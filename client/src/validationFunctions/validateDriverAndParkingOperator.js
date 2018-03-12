import { DRIVER_ROLE_CODE, PARKING_OPERATOR_ROLE_CODE } from '../constants/ConstansValues';

const validateDriverAndParkingOperator = (inputValue, inputMaxLength, role) =>{
    const inputLength = inputValue.length;
    const inputValueLower = inputValue.toLowerCase();
    if (role === DRIVER_ROLE_CODE){
        return ((inputLength === inputMaxLength) && (!!inputValueLower.match(/^[0-9]+$/)));
    } else if (role === PARKING_OPERATOR_ROLE_CODE){
            return !((inputLength > inputMaxLength) || (!inputValueLower.match(/^[0-9]+$/)));
    }
}

export default validateDriverAndParkingOperator;