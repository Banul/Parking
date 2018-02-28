import React, { Component } from "react";
import './input.css';
import './button.css';

class ParkingOperator extends Component{

    state = {
        inputValue : '',

    }

    onInputFindByIDChange(){
        console.log("change");
    }

    onInputFindByVehicleNumChange(){
        console.log("change num");
    }

    render(){
        return(
            <div>
                <div>Chosen role : ParkingOperator</div>
                <input className = "input" onChange = {this.onInputFindByIDChange} />
                <button type="button" className="button btn btn-success">Search driver by id</button>
                <p/>
                <input className = "input" onChange = {this.onInputFindByVehicleNumChange} />
                <button type = "button" className = "button byn btn-success">Search driver by vehicleNumber</button>
                
            </div>

        )
    }
}

export default ParkingOperator;