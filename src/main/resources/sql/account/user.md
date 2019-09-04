selectByDepartId
===
    select * from lw_user where user_did=#departId# order by user_create_time desc

getUserPage
===
    select 
    @pageTag(){
    *
    @}
    from lw_user
    where 1 = 1
    @if(!isEmpty(user_name)){
        and user_name like "%"#userName#"%"
    @}
    @if(!isEmpty(user_nickname)){
        and user_nickname like "%"#userNickname#"%"
    @}
    @pageIgnoreTag(){
    order by user_create_time desc
    @}
    