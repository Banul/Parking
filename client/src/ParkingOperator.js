import React, { Component } from "react";
import InputAndButtonComponent from './InputAndButtonComponent';
import DataCreatorForParkingOperator from './DataCreatorForParkingOperator';
import './input.css';
import './button.css';
import axios from 'axios';


class ParkingOperator extends Component{
        
    state = {
        inputValueID : '',
        currentDriverId: '',
        parkingMeterStatus: '',
        buttonClicked: false,
        requestStatus: '',
        currentDriverVehicleNumber: ''
    }

    onInputChange = (event) => {
        this.setState({
            inputValueID: event.target.value
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
        this.getData();
    }

    render(){
        return(
            <div>
                <InputAndButtonComponent role = "parking operator"
                                         onInputChange = {this.onInputChange}
                                         text = "Get driver by ID"
                                         onButtonClicked = {this.onButtonClicked}
                                         />
           
                <DataCreatorForParkingOperator currentDriverId = {this.state.currentDriverId} 
                                               buttonClicked = {this.state.buttonClicked}
                                               currentDriverId = {this.state.currentDriverId}
                                               requestStatus = {this.state.requestStatus}
                                               currentDriverVehicleNumber = {this.state.currentDriverVehicleNumber}
                                               parkingMeterStatus = {this.state.parkingMeterStatus} />
                                        
            </div>

        )
    }
}

export default ParkingOperator;