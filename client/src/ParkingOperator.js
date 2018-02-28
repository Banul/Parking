import React, { Component } from "react";
import InputAndButtonComponent from './InputAndButtonComponent';
import DataCreatorForParkingOperator from './DataCreatorForParkingOperator';
import './input.css';
import './button.css';
import axios from 'axios';


class ParkingOperator extends Component{
        
    state = {
        inputValueID : '',
        inputValueVehicle : '',
        currentDriverId: '',
        currentDriverVehicleNumber: '',
        parkingMeterStatus: '',
        buttonClicked: false,
        requestStatus: ''
    }

    onInputChange = (event) => {
        this.setState({
            inputValueID: event.target.value
        });
    }

    getData= () => {
        const ID = this.state.inputValueID;
        const URL = `http://localhost:8080/driver/id/${ID}`;
        axios.get(URL).then(results =>{
            const driverId = results.data.id;
            const vehicleNumber = results.data.vehicleNumber;
            const meterActive = results.data.meterActive;
            const requestStatus = results.status;
            let parkingMeterStatus;

            if (meterActive === false){
                parkingMeterStatus = "not working";
            }
            else{
                parkingMeterStatus = "working"
            }

            this.setState({
                currentDriverId: driverId,
                currentDriverVehicleNumber: vehicleNumber,
                isParkingMeterStarted: meterActive,
                parkingMeterStatus: parkingMeterStatus,
                buttonClicked: true,
                requestStatus: requestStatus
            })
        })
    }

    onButtonClicked = () => {
        console.log("buttonIdClicked");
        this.getData();
    }

    render(){
        return(
            <div>
                <InputAndButtonComponent role = "driver"
                                         onInputChange = {this.onInputChange}
                                         onButtonClicked = {this.onButtonClicked}/>
           
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