import React, {Component} from 'react';
import Character from './Character';
class Roaster extends Component{
    constructor(){
        super();

        this.state = {
            charArr: []
        }
    }

    componentDidMount(){
        fetch('http://localhost:9999/roster').then(data => {
            return data.json();
        }).then(parsedData => {
            this.setState(({charArr: parsedData}))
        })
    }

    render(){
        return(
            <div>
                 {this.state.charArr.map((x, index) => {
                     return <Character key={index} params={x} />
                 })}
            </div>
        )
    }
}

export default Roaster