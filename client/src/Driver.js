import React, {Component} from 'react';
import InputAndButtonComponent from './InputAndButtonComponent';
import DataCreatorForDriver from './DataCreatorForDriver';
import axios from 'axios';

class Driver extends Component{

    state = {
        cost: '',
        searchButtonClicked: false,
        getStatus: '',
        inputPeselValue: '',
        currentlyShownPesel: '',
        isMeterActive: '',
        putStatus: '',
        showDataAboutCurrentMeterStatus: true
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
        const peselToCheck = this.state.inputPeselValue;
        const URL = `http://localhost:8080/driver/getCost/${peselToCheck}`;
        axios.get(URL).then(results => {
            this.setState({
                cost: results.data.cost,
                getStatus: results.status,
                buttonClicked: true,
                currentlyShownPesel: peselToCheck,
                isMeterActive: results.data.meterActive,
                showDataAboutCurrentMeterStatus: true

            })
        })
         .catch(error => {
            this.setState({
                getStatus: 404,
                buttonClicked: true,
                showDataAboutCurrentMeterStatus: true

            })
        })
        
    }

    onMeterButtonClicked = (action) => {
        const URL = "http://localhost:8080/driver/updateDriver"+action+"Meter";
        axios.put(URL, {pesel: this.state.currentlyShownPesel})
            .then(results => {
                this.setState({
                    putStatus: results.status,
                    showDataAboutCurrentMeterStatus: false
                })
            })
            .catch(error => {
                this.setState({
                    putStatus: 404,
                    showDataAboutCurrentMeterStatus: false
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
             <DataCreatorForDriver requestStatus = {this.state.getStatus}
                                   price = {this.state.cost}
                                   buttonClicked = {this.state.buttonClicked}
                                   chosenPesel = {this.state.currentlyShownPesel}
                                   isMeterActive = {this.state.isMeterActive}
                                   onMeterButtonClicked = {(action) => this.onMeterButtonClicked(action)}
                                   putStatus = {this.state.putStatus}
                                   showDataAboutCurrentMeterStatus = {this.state.showDataAboutCurrentMeterStatus}
             />  
            </div>                         
        )
    }
}

export default Driver;