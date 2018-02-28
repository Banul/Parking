import React, { Component } from "react";
import InputAndButtonComponent from './InputAndButtonComponent';
import axios from 'axios';

class ParkingOwner extends Component{

    state = {
       inputValueID : '',
       currentDriverId: '',
       buttonClicked: false,
       requestStatus: '',
       cost: ''

    }

    onInputChange = (event) => {
        this.setState({
            inputValueID: event.target.value
        });
    }

    getData = () => {
        const date = this.state.inputValueID;
        const URL = `http://localhost:8080/transactionAggregate/${date}`;
        axios.get(URL).then(results => {
            console.log(results);
        })


    }

     onButtonClicked = () => {
        this.getData();
    }

    render(){
        return(
            <div>
                <InputAndButtonComponent role = "parking owner"
                                         text = "Get driver by ID"
                                         onInputChange = {this.onInputChange}
                                         onButtonClicked = {this.onButtonClicked}/>
            </div>
        )
    }
}

export default ParkingOwner;