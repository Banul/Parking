import React from 'react';

const InputAndButtonComponent = (props) => {
    return (
        <div>
             <div>Chosen role : {props.role}</div>
                <input className = "input" onChange = {props.onInputChange} />
                <button type="button" className="btn btn-info" onClick = {props.onButtonClicked}>Search driver by id</button>
                <p/>
        </div>
    )
}

export default InputAndButtonComponent;