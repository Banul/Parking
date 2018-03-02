import { DRIVER_ROLE_CODE, PARKING_OPERATOR_ROLE_CODE } from '../constances/ConstansValues';

const validateDriverAndParkingOperator = (inputValue, inputMaxLength, role) =>{
    const inputLength = inputValue.length;
    const inputValueLower = inputValue.toLowerCase();
    if (role === DRIVER_ROLE_CODE){
      if ((inputLength !== inputMaxLength || !inputValueLower.match(/^[0-9]+$/))){
            return false;
    }
    else{
            return true;
        }
    }
    else if (role === PARKING_OPERATOR_ROLE_CODE){
           if ((inputLength > inputMaxLength || !inputValueLower.match(/^[0-9]+$/))){
            return false;
    }
    else{
            return true;
        }
    }
}

export default validateDriverAndParkingOperator;