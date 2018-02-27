import React from 'react';
import './RoleButton.css';

const RoleButton = (props) =>{
    return (
         <button  type="button"  className="button btn btn-primary myButton col-sm-3" onClick = {() => {props.onButtonClicked(props.roleName)}}>
            {props.roleName}
        </button>
    )
}

export default RoleButton;