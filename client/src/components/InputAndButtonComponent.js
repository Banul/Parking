import React from 'react';
import '../styles/input.css';

const InputAndButtonComponent = (props) => {
    return (
        <div>
             <div>Chosen role : {props.role}</div>
                <input className = "input" onChange = {props.onInputChange} />
                <button type="button" className="btn btn-info" onClick = {props.onButtonClicked}>{props.text}</button>
                <p/>
        </div>
    )
}

export default InputAndButtonComponent;