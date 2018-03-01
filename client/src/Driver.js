import React, {Component} from 'react';
import InputAndButtonComponent from './InputAndButtonComponent';
import DataCreatorForDriver from './DataCreatorForDriver';
import axios from 'axios';
import driverValidation from './driverValidation';
import ValidationWarningReturner from './ValidationWarningReturner';

class Driver extends Component{

    state = {
        cost: '',
        searchButtonClicked: false,
        getStatus: '',
        inputPeselValue: '',
        currentlyShownPesel: '',
        isMeterActive: '',
        putStatus: '',
        showDataAboutCurrentMeterStatus: true,
        showDataAboutSuccessfullPut: false,
        driverValidationStatus: ''
    }

    onInputChange = (event) => {
        this.setState({
            inputPeselValue: event.target.value,
            driverValidationStatus: true,
            showDataAboutSuccessfullPut: false
        });
    }

    onButtonClicked = () => {
        const validationStatus = driverValidation(this.state.inputPeselValue);
        if (validationStatus === true){
            this.getData();
        }
        else{
            this.setState({
                driverValidationStatus: false,
                showDataAboutCurrentMeterStatus: false
            })
        }
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
                    showDataAboutCurrentMeterStatus: false,
                    showDataAboutSuccessfullPut: true
                })
            })
            .catch(error => {
                this.setState({
                    putStatus: 404,
                    showDataAboutCurrentMeterStatus: false,
                    showDataAboutSuccessfullPut: false
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
            <ValidationWarningReturner validationStatus = {this.state.driverValidationStatus}/>
             <DataCreatorForDriver requestStatus = {this.state.getStatus}
                                   price = {this.state.cost}
                                   buttonClicked = {this.state.buttonClicked}
                                   chosenPesel = {this.state.currentlyShownPesel}
                                   isMeterActive = {this.state.isMeterActive}
                                   onMeterButtonClicked = {(action) => this.onMeterButtonClicked(action)}
                                   putStatus = {this.state.putStatus}
                                   showDataAboutCurrentMeterStatus = {this.state.showDataAboutCurrentMeterStatus}
                                   driverValidation = {this.state.driverValidationStatus}
                                   showDataAboutSuccessfullPut = {this.state.showDataAboutSuccessfullPut}
             />  
            </div>                         
        )
    }
}

export default Driver;