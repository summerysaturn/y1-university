CREATE TABLE  tCust (
	 custID   int  NOT NULL,
	 fname   varchar (50) NULL,
	 sname   varchar (50) NOT NULL,
	 addressLine1   varchar (50) NOT NULL,
	 addressLine2   varchar (50) NULL,
	 city   varchar (50) NULL,
	 country   varchar (50) NULL,
	 deleteFlag   boolean  NOT NULL,
	 catID   varchar (1) NULL
); 

CREATE TABLE tOrder ( 
    	salesOrderID int NOT NULL, 
   	orderDate date NOT NULL, 
    	shipDate date NULL, 
   	customerID int NOT NULL, 
    	subtotal numeric NOT NULL, 
    	taxAmt numeric NOT NULL, 
    	TotalDue numeric NOT NULL, 
    	comment varchar (128) NULL 
);

CREATE TABLE    tProduct (
	 ProductID   int   NOT NULL,
	 Name    varchar (50) NOT NULL,
	 ProductNumber    varchar (25) NOT NULL,
	 MakeFlag   boolean  NOT NULL,
	 FinishedGoodsFlag   boolean  NOT NULL,
	 Color    varchar (15) NULL,
	 SafetyStockLevel   smallint  NOT NULL,
	 ReorderPoint   smallint  NOT NULL,
	 StandardCost   numeric  NOT NULL,
	 ListPrice   numeric  NOT NULL,
	 Size    varchar (5) NULL,
	 SizeUnitMeasureCode   char (3) NULL,
	 WeightUnitMeasureCode   char (3) NULL,
	 Weight   decimal (8, 2) NULL,
	 DaysToManufacture   int  NOT NULL,
	 ProductLine   char (2) NULL,
	 Class   char (2) NULL,
	 Style   char (2) NULL,
	 ProductSubcategoryID   int  NULL,
	 ProductModelID   int  NULL,
	 SellStartDate   date  NOT NULL,
	 SellEndDate   date  NULL,
	 DiscontinuedDate   date  NULL
); 

CREATE TABLE  tOrderLine (
	 SalesOrderID   int  NOT NULL,
	 CarrierTrackingNumber   varchar (25) NULL,
	 OrderQty   smallint  NOT NULL,
	 ProductID   int  NOT NULL,
	 SpecialOfferID   int  NOT NULL,
	 UnitPrice   numeric  NOT NULL,
	 UnitPriceDiscount   numeric  NOT NULL,
	 LineTotal   numeric (38, 6) NOT NULL

);
