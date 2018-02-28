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
        startedParkingMeter: ''
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
        let ID = this.state.inputValueID;
        let URL = `http://localhost:8080/driver/id/${ID}`;
        axios.get(URL).then(results =>{
            console.log(results);
        })

    }

    onButtonIdClicked = () => {
        console.log("buttonIdClicked");
        this.getDataById();
    }

    onButtonVehicleClicked = () => {
        console.log("buttonVehicleClicked");
    }

    render(){
        console.log(this.state.inputValueID);
        return(
            <div>
                <div>Chosen role : ParkingOperator</div>
                <input className = "input" onChange = {this.onInputFindByIDChange} />
                <button type="button" className="button btn btn-success" onClick = {this.onButtonIdClicked}>Search driver by id</button>
                <p/>
                <input className = "input" onChange = {this.onInputFindByVehicleNumChange} />
                <button type = "button" className = "button btn btn-success" onClick = {this.onButtonVehicleClicked}>Search driver by vehicleNumber</button>
                
            </div>

        )
    }
}

export default ParkingOperator;