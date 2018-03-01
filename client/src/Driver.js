import React, {Component} from 'react';
import InputAndButtonComponent from './InputAndButtonComponent';
import DataCreatorForDriver from './DataCreatorForDriver';
import axios from 'axios';

class Driver extends Component{

    state = {
        cost: '',
        searchButtonClicked: false,
        requestStatus: '',
        inputPeselValue: '',
        currentlyShownPesel: '',
        isMeterActive: ''
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
        const peselTocheck = this.state.inputPeselValue;
        const URL = `http://localhost:8080/driver/getCost/${peselTocheck}`;
        axios.get(URL).then(results => {
            this.setState({
                cost: results.data.cost,
                requestStatus: results.status,
                buttonClicked: true,
                currentlyShownPesel: peselTocheck,
                isMeterActive: results.data.meterActive

            })
        })
         .catch(error => {
            this.setState({
                requestStatus: 404,
                buttonClicked: true
            })
        })
        
    }

    render(){
        return(
            <div>
             <InputAndButtonComponent role = "driver"
                                         onInputChange = {this.onInputChange}
                                         text = "Get cost by PESEL"
                                         onButtonClicked = {this.onButtonClicked}
                                         />
             <DataCreatorForDriver requestStatus = {this.state.requestStatus}
                                   price = {this.state.cost}
                                   buttonClicked = {this.state.buttonClicked}
                                   chosenPesel = {this.state.currentlyShownPesel}
                                   isMeterActive = {this.state.isMeterActive}

             
             />  
            </div>                         
        )
    }
}

export default Driver;