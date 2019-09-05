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
    @if(!isBlank(userName)){
        and user_name like "%"#userName#"%"
    @}
    @if(!isBlank(userNickName)){
        and user_nick_name like "%"#userNickName#"%"
    @}
    @pageIgnoreTag(){
    order by user_create_time desc
    @}
    