getMenusByUser
===
    SELECT e.* FROM lw_user a
    LEFT JOIN lw_user_role b ON a.`USER_ID` = b.`UR_USER_ID`
    LEFT JOIN lw_role c ON b.`UR_ROLE_ID` = c.`ROLE_ID`
    LEFT JOIN lw_role_menu	d ON c.`ROLE_ID` = d.`RM_ROLE_ID`
    LEFT JOIN lw_menu e ON d.`RM_MENU_ID` = e.`MENU_ID`
    WHERE a.`USER_ID`  = #userId#
    
getResourcesByUser
===
    SELECT f.* FROM lw_user a 
    LEFT JOIN lw_user_role b ON a.`USER_ID` = b.`UR_USER_ID`
    LEFT JOIN lw_role c ON b.`UR_ROLE_ID` = c.`ROLE_ID`
    LEFT JOIN lw_role_menu_resource d ON c.`ROLE_ID` = d.`RMR_ROLE_ID`
    LEFT JOIN lw_menu_resource e ON d.`RMR_ROLE_MR_ID` = e.`MR_ID`
    LEFT JOIN lw_resource f ON e.`MR_RESOURCE_ID` = f.`RESOURCE_ID`
    WHERE 1 = 1 
    @if(!isEmpty(user)){
        and a.`USER_ID` = #user.userId#
    @}
    @if(!isEmpty(menuId)){
        AND e.`MR_MENU_ID` = #menuId#;
    @}
