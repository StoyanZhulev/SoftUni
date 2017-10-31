import React from 'react';

import observerMenu from './../utils/observer';

let singleChar = (props) => {
    return (
        <div onClick={ () => {
            observerMenu.executeObserver('changeFocus', {id: props.params.id});
            observerMenu.executeObserver('changeState', props.params.id);
        }} className="char-div">
            <img className="char-img" alt="char" src={props.params.url} />
        </div>)
}

export default singleChar
