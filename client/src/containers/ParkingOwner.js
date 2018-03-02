import React, { Component } from "react";
import axios from 'axios';
import InputAndButtonComponent from '../components/InputAndButtonComponent';
import DataCreatorForParkingOwner from '../components/DataCreatorForParkingOwner';
import {TRANSACTION_AGGREGATE} from '../constances/ConstansLinks';
import {PARKING_OWNER_ROLE_CODE} from '../constances/ConstansValues';
import validateParkingOwner from '../validationFunctions/validateParkingOwner';
import ValidationWarningReturner from '../components/ValidationWarningReturner';

class ParkingOwner extends Component{

    state = {
       inputDate : '',
       buttonClicked: false,
       requestStatus: '',
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
                income: results.data.totalIncome,
                checkedDate: results.data.date,
                buttonClicked: true,
                requestStatus: results.status
            })
        })
        .catch(error => {
            this.setState({
                requestStatus: 404,
                buttonClicked: true

            })
        })
    }

     onButtonClicked = () => {
        const validationStatus = validateParkingOwner(this.state.inputDate);
        if (validationStatus === true){
            this.getData();
        }
        else {
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
                                            requestStatus = {this.state.requestStatus}
                                            income = {this.state.income}/>
            </div>
        )
    }
}

export default ParkingOwner;