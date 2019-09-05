getCommonPage
===
        select 
        *
        from #text(tableName)#
        where 1 = 1
        @for(val in list){
          and #text(val)# 
        @}
        
getCommonPage$count
===
        select 
        count(1)
        from #text(tableName)#
        where 1 = 1
        @for(val in list){
          and #text(val)# 
        @}