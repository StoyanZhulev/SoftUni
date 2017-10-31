import React, { Component } from 'react';
import Character from './Character';

import observerMenu from './../utils/observer';

class Bio extends Component {
    constructor() {
        super();

        this.state = {
            id: 0,
            currChar: {
                url: '',
                bio: ''
            }
        }

        this.eventHandler = (id) => {

            fetch('http://localhost:9999/character/' + id)
                .then(data => {
                    return data.json();
                }).then(parsedData => {
                    this.setState({ id: id,
                        currChar: parsedData 
                     });
                }).catch(e => {
                    console.log(e);
                })
        }

    }

    componentDidMount() {
        if (!observerMenu['changeState']) {
            observerMenu.addObserver('changeState', this.eventHandler)
        }
        fetch('http://localhost:9999/character/' + this.state.id)
            .then(data => {
                return data.json();
            }).then(parsedData => {
                console.log(parsedData);

                this.setState({ currChar: parsedData });
            })
    }

    render() {
        return (
            <div>
                <fieldset>
                    <Character params={({ url: this.state.currChar.url })} />
                    <p>{this.state.currChar.bio}</p>
                </fieldset>
            </div>

        )
    }
}

export default Bio;