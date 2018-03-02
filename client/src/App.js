import React, { Component } from 'react';
import './App.css';
import Menu from './components/Menu';
import { BrowserRouter } from 'react-router-dom';


class App extends Component {
  render() {
    return (
     <BrowserRouter>
      <div className="App">
        <Menu/>
      </div>
     </BrowserRouter>
    );
  }
}

export default App;
