import React from 'react';
import RoleButton from './RoleButton';

const RolesButtonList = (props) => {
   const buttonList = props.roles.map(role => {
        return <RoleButton 
            onButtonClicked = {props.onRoleButtonClicked}
            roleName = {role}
            key = {role} />
   })

        return(
            <div>
                {buttonList}
            </div>
        )
   
}

export default RolesButtonList;