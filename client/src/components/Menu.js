import React from 'react';
import { Route, Link } from 'react-router-dom';
import Driver from '../containers/Driver';
import Home from './Home';
import ParkingOperator from '../containers/ParkingOperator';
import ParkingOwner from '../containers/ParkingOwner';


const Menu = () => {
return(
  <div>
    <nav className="navbar navbar-inverse">
      <div className="container-fluid">
        <div className="navbar-header">
        </div>
        <ul className="nav navbar-nav">
          <li><Link to = "/">Home</Link></li>
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