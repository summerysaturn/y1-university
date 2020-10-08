
/*amend the following line to use your own database
you won't be able to use mine*/
use xxxxxxx


select *
into tCust
from ci402_teaching.dbo.tCust
go

select *
into tOrder
from ci402_teaching.dbo.tOrder
go

select *
into tProduct
from ci402_teaching.dbo.tProduct
go


select *
into tOrderLine
from ci402_teaching.dbo.tOrderLine
go
