import React, { Component } from "react";
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
        buttonClicked: false
    }

    onInputFindByIDChange = (event) => {
        this.setState({
            inputValueID: event.target.value
        });
    }

    onInputFindByVehicleNumChange = (event) => {
        this.setState({
            inputValueID: event.target.value
        });
    }    

    getDataById = () => {
        const ID = this.state.inputValueID;
        const URL = `http://localhost:8080/driver/id/${ID}`;
        axios.get(URL).then(results =>{
            console.log(results);
            const driverId = results.data.id;
            const vehicleNumber = results.data.vehicleNumber;
            const meterActive = results.data.meterActive;
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
                buttonClicked: true
            })
        })
    }

    onButtonIdClicked = () => {
        console.log("buttonIdClicked");
        this.getDataById();
    }

    createInfo = () =>{
        let divToReturn = <div></div>
        if (this.state.currentDriverId !== undefined){
            const styleSuccess = {
               margin: "20px",
               color: "#006603"
             }
            divToReturn =  <div style = {styleSuccess}> 
               <p> Driver id : {this.state.currentDriverId} </p>
               <p> Driver's vehicle number : {this.state.currentDriverVehicleNumber} </p>
               <p> Meter status : {this.state.parkingMeterStatus} </p>

            </div>
        }
        else if (this.state.buttonClicked & this.state.currentDriverId === undefined){
            const styleError = {
                margin: "20px",
                color: "#670003"
            }
            divToReturn = <div style = {styleError}> Driver with entered id does not exist </div>
        }
       
        return divToReturn

    }

    render(){
        console.log(this.state);
        return(
            <div>
                <div>Chosen role : Parking operator</div>
                <input className = "input" onChange = {this.onInputFindByIDChange} />
                <button type="button" className="btn btn-info" onClick = {this.onButtonIdClicked}>Search driver by id</button>
                <p/>
                {this.createInfo()}
            </div>

        )
    }
}

export default ParkingOperator;