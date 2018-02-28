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
        startedParkingMeter: '',
        requestStatus: ''
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
            const status = results.status;
            const driverId = results.data.id;
            const vehicleNumber = results.data.vehicleNumber;
            const meterActive = results.data.meterActive;
            this.setState({
                currentDriverId: driverId,
                currentDriverVehicleNumber: vehicleNumber,
                startedParkingMeter: meterActive,
                requestStatus: status
            })
        })
        .catch(error => {
            this.setState({
                requestStatus: 500
            })
        })
    }

    onButtonIdClicked = () => {
        console.log("buttonIdClicked");
        this.getDataById();
    }

    onButtonVehicleClicked = () => {
        console.log("buttonVehicleClicked");
    }

    createInfo = () =>{
        let divToReturn = <div></div>
        if (this.state.requestStatus === 200){
            divToReturn =  <div>
               <p> Driver id : {this.state.currentDriverId} </p>
               <p> Driver's vehicle number : {this.state.currentDriverVehicleNumber} </p>

            </div>
        }
        else if (this.state.requestStatus === 500){
            divToReturn = <div> Driver with entered id does not exist </div>
        }
       
        return divToReturn

    }

    render(){
        console.log(this.state.requestStatus);
        return(
            <div>
                <div>Chosen role : ParkingOperator</div>
                <input className = "input" onChange = {this.onInputFindByIDChange} />
                <button type="button" className="button btn btn-success" onClick = {this.onButtonIdClicked}>Search driver by id</button>
                <p/>
                <input className = "input" onChange = {this.onInputFindByVehicleNumChange} />
                <button type = "button" className = "button btn btn-success" onClick = {this.onButtonVehicleClicked}>Search driver by vehicleNumber</button>
                {this.createInfo()}
            </div>

        )
    }
}

export default ParkingOperator;