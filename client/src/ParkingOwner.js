import React, { Component } from "react";
import InputAndButtonComponent from './InputAndButtonComponent';
import DataCreatorForParkingOwner from './DataCreatorForParkingOwner';
import axios from 'axios';

class ParkingOwner extends Component{

    state = {
       inputDate : '',
       buttonClicked: false,
       requestStatus: '',
       income: '',
       checkedDate: ''

    }

    onInputChange = (event) => {
        this.setState({
            inputDate: event.target.value
        });
    }

    getData = () => {
        const date = this.state.inputDate;
        console.log(date);
        const URL = `http://localhost:8080/transactionAggregate/${date}`;
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
        this.getData();
    }

    render(){
        console.log(this.state);
        return(
            <div>
                <InputAndButtonComponent role = "parking owner"
                                         text = "Check income for a given day"
                                         onInputChange = {this.onInputChange}
                                         onButtonClicked = {this.onButtonClicked}/>

                <DataCreatorForParkingOwner buttonClicked = {this.state.buttonClicked}
                                            checkedDate = {this.state.checkedDate}
                                            requestStatus = {this.state.requestStatus}
                                            income = {this.state.income}/>
            </div>
        )
    }
}

export default ParkingOwner;