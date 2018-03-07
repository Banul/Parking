import React, { Component } from "react";
import axios from 'axios';
import InputAndButtonComponent from '../components/InputAndButtonComponent';
import DataCreatorForParkingOwner from '../components/DataCreatorForParkingOwner';
import {TRANSACTION_AGGREGATE} from '../constants/ConstansLinks';
import {PARKING_OWNER_ROLE_CODE} from '../constants/ConstansValues';
import validateParkingOwner from '../validationFunctions/validateParkingOwner';
import ValidationWarningReturner from '../components/ValidationWarningReturner';

class ParkingOwner extends Component{

    state = {
       inputDate : '',
       buttonClicked: false,
       currency: '',
       errorGet: '',
       income: '',
       checkedDate: '',
       parkingOwnerValidationStatus: ''
    }

    onInputChange = (event) => {
        this.setState({
            inputDate: event.target.value,
            parkingOwnerValidationStatus: true
        });
    }

    getData = () => {
        const date = this.state.inputDate;
        const URL = `${TRANSACTION_AGGREGATE}/${date}`;
        axios.get(URL).then(results => {
            this.setState({
                income: results.data.moneyModel.amount,
                currency: results.data.moneyModel.currency,
                checkedDate: results.data.date,
                buttonClicked: true,
                requestStatus: results.status,
                errorGet: true
            })
        })
        .catch(error => {
            this.setState({
                errorGet: false,
                buttonClicked: true

            })
        })
    }

     onButtonClicked = () => {
        const validationStatus = validateParkingOwner(this.state.inputDate);
        if (validationStatus === true){
            this.getData();
        } else {
            this.setState({
                parkingOwnerValidationStatus: false
            })
        }
    }

    render(){
        return(
            <div>
                <InputAndButtonComponent role = {PARKING_OWNER_ROLE_CODE}
                                         text = "Check income for a given day"
                                         onInputChange = {this.onInputChange}
                                         onButtonClicked = {this.onButtonClicked}/>
            
                <ValidationWarningReturner validationStatus = {this.state.parkingOwnerValidationStatus}/>

                <DataCreatorForParkingOwner buttonClicked = {this.state.buttonClicked}
                                            checkedDate = {this.state.checkedDate}
                                            errorGet = {this.state.errorGet}
                                            income = {this.state.income}
                                            currency = {this.state.currency}/>
            </div>
        )
    }
}

export default ParkingOwner;