import React from 'react';
import { Route, Link } from 'react-router-dom';
import Driver from './Driver';
import Home from './Home';
import ParkingOperator from './ParkingOperator';
import ParkingOwner from './ParkingOwner';


const Menu = () => {
    return(
        <div>
          <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
    </div>
    <ul class="nav navbar-nav">
      <li><Link to = "/home">Home</Link></li>
      <li><Link to="/parkingOperator">Parking operator</Link></li>
      <li><Link to="/parkingOwner">Parking owner</Link></li>
      <li><Link to="/driver">Driver</Link></li>
    </ul>
  </div>
</nav>
    <Route path = "/" exact component = { Home }/>
    <Route path = "/driver" exact component = { Driver }/>
    <Route path = "/parkingOperator" exact component = { ParkingOperator }/>
    <Route path = "/parkingOwner" exact component = {ParkingOwner}/>
    </div>
    )
}

export default Menu;