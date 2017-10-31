import React, { Component } from 'react';

import left from './../resources/left.png';
import right from './../resources/right.png';

class Slider extends Component {

    constructor(){
        super();

        this.state = {
            focusedEpId: 0,
            imgUrl: ''
        }

        this.getNewEp = (id) => {
            fetch('http://localhost:9999/episodePreview/' + id)
            .then(data => {
                return data.json()
            }).then(parsedData => {
                this.setState(({focusedEpId: parsedData.id}));
                this.setState(({imgUrl: parsedData.url}));
            })
        }
    }

    componentDidMount(){
        fetch('http://localhost:9999/episodePreview/' + this.state.focusedEpId)
            .then(data => {
                return data.json();
            }).then(parsedDate => {
                this.setState(({imgUrl: parsedDate.url}));
            })
    }

    render() {
        return (
            <div className="warper">
                <img onClick={() => {
                    this.getNewEp(Number(this.state.focusedEpId) - 1);
                }} className="case-left slider-button" alt="leftArrow" src={left} />
                <img className="sliderImg" alt="focusedEp" src={this.state.imgUrl} />
                <img onClick={() => {
                    this.getNewEp(Number(this.state.focusedEpId) + 1);
                }} className="case-right slider-button" alt="leftArrow" src={right} />
            </div>
        )
    }
}

export default Slider;