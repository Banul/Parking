import React, { Component } from "react";
import InputAndButtonComponent from './InputAndButtonComponent';
import DataCreatorForParkingOperator from './DataCreatorForParkingOperator';
import './input.css';
import './button.css';
import axios from 'axios';
import driverAndParkingOperatorValidation from './driverAndParkingOperatorValidation';
import { MAX_INPUT_LENGTH_PARKING_OPERATOR, PARKING_OPERATOR_ROLE_CODE } from './ConstansClass';
import ValidationWarningReturner from './ValidationWarningReturner';

class ParkingOperator extends Component{
        
    state = {
        inputValueID : '',
        currentDriverId: '',
        parkingMeterStatus: '',
        buttonClicked: false,
        requestStatus: '',
        currentDriverVehicleNumber: '',
        parkingOperatorValidationStatus: ''
    }

    onInputChange = (event) => {
        this.setState({
            inputValueID: event.target.value,
            parkingOperatorValidationStatus: true
        });
    }

    getData= () => {
        const ID = this.state.inputValueID;
        const URL = `http://localhost:8080/driver/id/${ID}`;
        let parkingMeterStatus;
        axios.get(URL).then(results =>{
            if (!results.data.meterActive){
                parkingMeterStatus = "not working";
            }
            else{
                parkingMeterStatus = "working"
            }

            this.setState({
                currentDriverId: results.data.id,
                currentDriverVehicleNumber: results.data.vehicleNumber,
                isParkingMeterStarted: results.data.meterActive,
                parkingMeterStatus: parkingMeterStatus,
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
        const validationStatus = driverAndParkingOperatorValidation(this.state.inputValueID, MAX_INPUT_LENGTH_PARKING_OPERATOR, PARKING_OPERATOR_ROLE_CODE);
        if (validationStatus === true){
            this.getData();
        }
        else{
            this.setState({
                parkingOperatorValidationStatus: false,
            })
        }
    }

    render(){
        return(
            <div>
                <InputAndButtonComponent role = {PARKING_OPERATOR_ROLE_CODE}
                                         onInputChange = {this.onInputChange}
                                         text = "Get driver by ID"
                                         onButtonClicked = {this.onButtonClicked}
                                         />
                <ValidationWarningReturner validationStatus = {this.state.parkingOperatorValidationStatus}/>

                <DataCreatorForParkingOperator currentDriverId = {this.state.currentDriverId} 
                                               buttonClicked = {this.state.buttonClicked}
                                               requestStatus = {this.state.requestStatus}
                                               currentDriverVehicleNumber = {this.state.currentDriverVehicleNumber}
                                               parkingMeterStatus = {this.state.parkingMeterStatus} />
                                        
            </div>

        )
    }
}

export default ParkingOperator;