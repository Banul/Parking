import React from 'react';

const RoleButton = (props) =>{
    return (
         <button  type="button"  className="btn btn-primary myButton col-sm-3" onClick = {() => {props.onButtonClicked()}}>
            {props.roleName}
        </button>
    )
}

export default RoleButton;