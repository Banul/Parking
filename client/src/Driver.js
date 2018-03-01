import React, {Component} from 'react';
import InputAndButtonComponent from './InputAndButtonComponent';
import DataCreatorForDriver from './DataCreatorForDriver';
import axios from 'axios';

class Driver extends Component{

    state = {
        cost: '',
        chosenPesel: '',
        searchButtonClicked: false,
        requestStatus: '',
        inputPeselValue: ''
    }

    onInputChange = (event) => {
        this.setState({
            inputPeselValue: event.target.value
        });
    }

    onButtonClicked = () => {
        this.getData();
    }

    getData = () => {
        const pesel = this.state.inputPeselValue;
        const URL = "http://localhost:8080/driver/getCost/1111";
        axios.get(URL).then(results => {
            this.setState({
                cost: results.data.cost
            })
        })

        
    }

    render(){
        console.log(this.state);
        return(
             <InputAndButtonComponent role = "driver"
                                         onInputChange = {this.onInputChange}
                                         text = "Get cost by PESEL"
                                         onButtonClicked = {this.onButtonClicked}
                                         />
             <DataCreatorForDriver>                           
        )
    }
}

export default Driver;