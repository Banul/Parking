import React from 'react';
import { Route, Link } from 'react-router-dom';
import Driver from './Driver';


const Menu = () => {
    return(
        <div>
          <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
    </div>
    <ul class="nav navbar-nav">
      <li><Link to = "/">Home</Link></li>
      <li><Link to="/parkingOperator">Parking operator</Link></li>
      <li><Link to="/parkingOwner">Parking owner</Link></li>
      <li><Link to="/driver">Driver</Link></li>
    </ul>
  </div>
</nav>
    <Route path = "/driver" exact component = { Driver }/>
    </div>
    )
}

export default Menu;