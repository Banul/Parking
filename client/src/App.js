import React, { Component } from 'react';
import './App.css';
import RolesButtonList from './RolesButtonList';

const App = () => {
    const roles = ['driver', 'parking operator', 'parking owner'];
    
    const onRoleButtonClicked = () => {
      console.log("roole");
    }

    return (
      <div className="App">
          <h1> Choose Role </h1>
          <RolesButtonList 
            roles = {roles}
            onRoleButtonClicked = {onRoleButtonClicked}/>

      </div>
    );
}

export default App;
