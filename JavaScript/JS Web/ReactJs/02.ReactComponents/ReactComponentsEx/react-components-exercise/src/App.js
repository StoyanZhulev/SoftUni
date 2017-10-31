import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

import Slider from './components/Slider';
import Roaster from './components/Roaster';
import Character from './components/Character';
import Bio from './components/Bio';

import observerMenu from './utils/observer';

class App extends Component {
  constructor(){
    super();

    this.eventHandler = (newState) => {
      this.setState(newState);
    }
  }

  componentDidMount(){
    observerMenu.addObserver('changeFocus', this.eventHandler)
  }
  render() {
    return (
      <div className="App">
        <Slider />
        <Roaster />
        <Bio  />
      </div>
    );
  }
}

export default App;
