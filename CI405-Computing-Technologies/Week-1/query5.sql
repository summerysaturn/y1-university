select SalesOrderID,
OrderDate,
CustID,
firstname,       /*this line needs editing - use Object Explorer / phpMyAdmin to work out why*/
sName
FROM  tOrder
INNER JOIN tCust 
ON tOrder.CustomerID = tCust.CustID
go