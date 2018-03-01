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
        putStatus: ''
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
                showPanelToGetData: true

            })
        })
         .catch(error => {
            this.setState({
                getStatus: 404,
                buttonClicked: true,
                showPanelToGetData: true

            })
        })
        
    }

    onMeterButtonClicked = (action) => {
        console.log(action);
        const URL = "http://localhost:8080/driver/updateDriver"+action+"Meter";
        axios.put(URL, {pesel: this.state.currentlyShownPesel})
            .then(results => {
                console.log("onMeterButtonClicked");
                console.log(results.status);
                this.setState({
                    putStatus: results.status,
                    showPanelToGetData: false
                })
            })
            .catch(error => {
                this.setState({
                    putStatus: 404,
                    showPanelToGetData: false
                })
            })
    }
 
   render(){
       console.log("renderrender");
       console.log(this.state);
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
                                   showPanelToGetData = {this.state.showPanelToGetData}
             />  
            </div>                         
        )
    }
}

export default Driver;