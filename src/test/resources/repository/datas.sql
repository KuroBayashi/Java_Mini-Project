INSERT INTO DISCOUNT_CODE(DISCOUNT_CODE, RATE) 
	VALUES ('H', 16.00);
INSERT INTO DISCOUNT_CODE(DISCOUNT_CODE, RATE) 
	VALUES ('M', 11.00);
INSERT INTO DISCOUNT_CODE(DISCOUNT_CODE, RATE) 
	VALUES ('L', 7.00);
INSERT INTO DISCOUNT_CODE(DISCOUNT_CODE, RATE) 
	VALUES ('N', 0.00);

INSERT INTO MICRO_MARKET(ZIP_CODE, RADIUS, AREA_LENGTH, AREA_WIDTH) 
	VALUES ('95051', 255.59, 689.856, 478.479);
INSERT INTO MICRO_MARKET(ZIP_CODE, RADIUS, AREA_LENGTH, AREA_WIDTH) 
	VALUES ('94043', 157.869, 385.821, 147.538);
INSERT INTO MICRO_MARKET(ZIP_CODE, RADIUS, AREA_LENGTH, AREA_WIDTH)
	VALUES ('85638', 758.648, 328.963, 482.164);
INSERT INTO MICRO_MARKET(ZIP_CODE, RADIUS, AREA_LENGTH, AREA_WIDTH) 
	VALUES ('12347', 475.965, 385.849, 146.937);
INSERT INTO MICRO_MARKET(ZIP_CODE, RADIUS, AREA_LENGTH, AREA_WIDTH) 
	VALUES ('94401', 368.386, 285.848, 173.794);
INSERT INTO MICRO_MARKET(ZIP_CODE, RADIUS, AREA_LENGTH, AREA_WIDTH) 
	VALUES ('95035', 683.396, 472.859, 379.757);

INSERT INTO CUSTOMER(CUSTOMER_ID, DISCOUNT_CODE, ZIP, NAME, ADDRESSLINE1, ADDRESSLINE2, CITY, STATE, PHONE, FAX, EMAIL, CREDIT_LIMIT) 
	VALUES (1, 'N', '95051', 'Jumbo Eagle Corp', '111 E. Las Olivas Blvd', 'Suite 51', 'Fort Lauderdale', 'FL', '305-555-0188', '305-555-0189', 'jumboeagle@example.com', 100000);
INSERT INTO CUSTOMER(CUSTOMER_ID, DISCOUNT_CODE, ZIP, NAME, ADDRESSLINE1, ADDRESSLINE2, CITY, STATE, PHONE, FAX, EMAIL, CREDIT_LIMIT) 
	VALUES (2, 'M', '95051', 'New Enterprises', '9754 Main Street', 'P.O. Box 567', 'Miami', 'FL', '305-555-0148', '305-555-0149', 'www.new.example.com', 50000);
INSERT INTO CUSTOMER(CUSTOMER_ID, DISCOUNT_CODE, ZIP, NAME, ADDRESSLINE1, ADDRESSLINE2, CITY, STATE, PHONE, FAX, EMAIL, CREDIT_LIMIT) 
	VALUES (3, 'L', '94043', 'Small Bill Company', '8585 South Upper Murray Drive', 'P.O. Box 456', 'Alanta', 'GA', '555-555-0175', '555-555-0176', 'www.smallbill.example.com', 90000);
INSERT INTO CUSTOMER(CUSTOMER_ID, DISCOUNT_CODE, ZIP, NAME, ADDRESSLINE1, ADDRESSLINE2, CITY, STATE, PHONE, FAX, EMAIL, CREDIT_LIMIT) 
	VALUES (25, 'M', '12347', 'Wren Computers', '8989 Red Albatross Drive', 'Suite 9897', 'Houston', 'TX', '214-555-0133', '214-555-0134', 'www.wrencomp.example.com', 25000);
INSERT INTO CUSTOMER(CUSTOMER_ID, DISCOUNT_CODE, ZIP, NAME, ADDRESSLINE1, ADDRESSLINE2, CITY, STATE, PHONE, FAX, EMAIL, CREDIT_LIMIT) 
	VALUES (36, 'H', '95035', 'Bob Hosting Corp.', '65653 Lake Road', 'Suite 2323', 'San Mateo', 'CA', '650-555-0160', '650-555-0161', 'www.bobhostcorp.example.com', 65000);

INSERT INTO MANUFACTURER(MANUFACTURER_ID, NAME, ADDRESSLINE1, ADDRESSLINE2, CITY, STATE, ZIP, PHONE, FAX, EMAIL, REP) 
	VALUES (19985678, 'Happy End Searching', '5 81st Street', 'Suite 100', 'Mountain View', 'CA', '94043     ', '650-555-0102', '408-555-0103', 'happysearching@example.com', 'John Snow');
INSERT INTO MANUFACTURER(MANUFACTURER_ID, NAME, ADDRESSLINE1, ADDRESSLINE2, CITY, STATE, ZIP, PHONE, FAX, EMAIL, REP) 
	VALUES (19986982, 'Smith Bird Watching', '4000 Finch Circle', 'Building 14', 'Santa Clara', 'CA', '95051     ', '650-555-0111', '408-555-0112', 'www.sbw@example.com', 'Brian Washington');
INSERT INTO MANUFACTURER(MANUFACTURER_ID, NAME, ADDRESSLINE1, ADDRESSLINE2, CITY, STATE, ZIP, PHONE, FAX, EMAIL, REP) 
	VALUES (19974892, 'Wilson Fish Co', '20959 Whalers Ave', 'Building 3', 'San Jose', 'OH', '95128     ', '650-555-0133', '408-555-0133', 'www.wilsonfish@example.com', 'Matthew Williams');
INSERT INTO MANUFACTURER(MANUFACTURER_ID, NAME, ADDRESSLINE1, ADDRESSLINE2, CITY, STATE, ZIP, PHONE, FAX, EMAIL, REP) 
	VALUES (19986196, 'James Deli', '250 Marinade Blvd', 'Suite C', 'Novato', 'IL', '94949     ', '650-555-0144', '408-555-0145', 'www.jdeli@example.net', 'Phil Jones');
INSERT INTO MANUFACTURER(MANUFACTURER_ID, NAME, ADDRESSLINE1, ADDRESSLINE2, CITY, STATE, ZIP, PHONE, FAX, EMAIL, REP) 
	VALUES (19978451, 'All Sushi', '399 San Pablo Ave', 'Building 600', 'Cleveland', 'CA', '94530     ', '650-555-0140', '408-555-0143', 'www.allsushi@example.com', 'Teresa Ho');
INSERT INTO MANUFACTURER(MANUFACTURER_ID, NAME, ADDRESSLINE1, ADDRESSLINE2, CITY, STATE, ZIP, PHONE, FAX, EMAIL, REP) 
	VALUES (19982461, 'Soft Cables', '9988 Main Upper Street', 'Suite 100', 'Indianapolis', 'IA', '46290     ', '650-555-0151', '408-555-0152', 'www.cbales@example.com', 'Henry Adams');
INSERT INTO MANUFACTURER(MANUFACTURER_ID, NAME, ADDRESSLINE1, ADDRESSLINE2, CITY, STATE, ZIP, PHONE, FAX, EMAIL, REP) 
	VALUES (19984899, 'Mike Recording Industries', '5109 Union Street Road', 'Building 8A', 'San Alfred', 'CA', '94123     ', '415-555-0166', '415-555-0165', 'www.mikerecording@example.com', 'Mike Black');

INSERT INTO PRODUCT_CODE(PROD_CODE, DISCOUNT_CODE, DESCRIPTION) 
	VALUES ('SW', 'M', 'Software');
INSERT INTO PRODUCT_CODE(PROD_CODE, DISCOUNT_CODE, DESCRIPTION) 
	VALUES ('HW', 'H', 'Hardware');
INSERT INTO PRODUCT_CODE(PROD_CODE, DISCOUNT_CODE, DESCRIPTION) 
	VALUES ('FW', 'L', 'Firmware');
INSERT INTO PRODUCT_CODE(PROD_CODE, DISCOUNT_CODE, DESCRIPTION) 
	VALUES ('BK', 'L', 'Books');
INSERT INTO PRODUCT_CODE(PROD_CODE, DISCOUNT_CODE, DESCRIPTION) 
	VALUES ('CB', 'N', 'Cables');
INSERT INTO PRODUCT_CODE(PROD_CODE, DISCOUNT_CODE, DESCRIPTION) 
	VALUES ('MS', 'N', 'Misc');

INSERT INTO PRODUCT(PRODUCT_ID, MANUFACTURER_ID, PRODUCT_CODE, PURCHASE_COST, QUANTITY_ON_HAND, MARKUP, AVAILABLE, DESCRIPTION) 
	VALUES (980001, 19985678, 'SW', 1095.00, 800000, 8.25, 'TRUE', 'Identity Server');
INSERT INTO PRODUCT(PRODUCT_ID, MANUFACTURER_ID, PRODUCT_CODE, PURCHASE_COST, QUANTITY_ON_HAND, MARKUP, AVAILABLE, DESCRIPTION) 
	VALUES (980005, 19986982, 'SW', 11500.99, 500, 55.25, 'TRUE', 'Accounting Application');
INSERT INTO PRODUCT(PRODUCT_ID, MANUFACTURER_ID, PRODUCT_CODE, PURCHASE_COST, QUANTITY_ON_HAND, MARKUP, AVAILABLE, DESCRIPTION) 
	VALUES (980025, 19974892, 'HW', 2095.99, 3000, 15.75, 'TRUE', '1Ghz Sun Blade Computer');
INSERT INTO PRODUCT(PRODUCT_ID, MANUFACTURER_ID, PRODUCT_CODE, PURCHASE_COST, QUANTITY_ON_HAND, MARKUP, AVAILABLE, DESCRIPTION) 
	VALUES (980030, 19974892, 'FW', 59.95, 250, 40.00, 'TRUE', '10Gb Ram');
INSERT INTO PRODUCT(PRODUCT_ID, MANUFACTURER_ID, PRODUCT_CODE, PURCHASE_COST, QUANTITY_ON_HAND, MARKUP, AVAILABLE, DESCRIPTION) 
	VALUES (980032, 19974892, 'FW', 39.95, 50, 25.50, 'TRUE', 'Sound Card');
INSERT INTO PRODUCT(PRODUCT_ID, MANUFACTURER_ID, PRODUCT_CODE, PURCHASE_COST, QUANTITY_ON_HAND, MARKUP, AVAILABLE, DESCRIPTION) 
	VALUES (986710, 19982461, 'CB', 15.98, 400, 30.00, 'TRUE', 'Printer Cable');
INSERT INTO PRODUCT(PRODUCT_ID, MANUFACTURER_ID, PRODUCT_CODE, PURCHASE_COST, QUANTITY_ON_HAND, MARKUP, AVAILABLE, DESCRIPTION) 
	VALUES (985510, 19985678, 'HW', 595.00, 800, 5.75, 'FALSE', '24 inch Digital Monitor');
INSERT INTO PRODUCT(PRODUCT_ID, MANUFACTURER_ID, PRODUCT_CODE, PURCHASE_COST, QUANTITY_ON_HAND, MARKUP, AVAILABLE, DESCRIPTION) 
	VALUES (988765, 19985678, 'HW', 10.95, 25, 9.75, 'FALSE', '104-Key Keyboard');

INSERT INTO PURCHASE_ORDER(ORDER_NUM, CUSTOMER_ID, PRODUCT_ID, QUANTITY, SHIPPING_COST, SALES_DATE, SHIPPING_DATE, FREIGHT_COMPANY) 
	VALUES (10398001, 1, 980001, 10, 449.00, '2011-05-24', '2011-05-24', 'Poney Express');
INSERT INTO PURCHASE_ORDER(ORDER_NUM, CUSTOMER_ID, PRODUCT_ID, QUANTITY, SHIPPING_COST, SALES_DATE, SHIPPING_DATE, FREIGHT_COMPANY) 
	VALUES (10398002, 2, 980005, 8, 359.99, '2011-05-24', '2011-05-24', 'Poney Express');
INSERT INTO PURCHASE_ORDER(ORDER_NUM, CUSTOMER_ID, PRODUCT_ID, QUANTITY, SHIPPING_COST, SALES_DATE, SHIPPING_DATE, FREIGHT_COMPANY) 
	VALUES (10398003, 2, 980025, 25, 275.00, '2011-05-24', '2011-05-24', 'Poney Express');
INSERT INTO PURCHASE_ORDER(ORDER_NUM, CUSTOMER_ID, PRODUCT_ID, QUANTITY, SHIPPING_COST, SALES_DATE, SHIPPING_DATE, FREIGHT_COMPANY) 
	VALUES (10398004, 3, 980030, 10, 275.00, '2011-05-24', '2011-05-24', 'Poney Express');
INSERT INTO PURCHASE_ORDER(ORDER_NUM, CUSTOMER_ID, PRODUCT_ID, QUANTITY, SHIPPING_COST, SALES_DATE, SHIPPING_DATE, FREIGHT_COMPANY) 
	VALUES (10398005, 1, 980032, 100, 459.00, '2011-05-24', '2011-05-24', 'Poney Express');
INSERT INTO PURCHASE_ORDER(ORDER_NUM, CUSTOMER_ID, PRODUCT_ID, QUANTITY, SHIPPING_COST, SALES_DATE, SHIPPING_DATE, FREIGHT_COMPANY) 
	VALUES (10398006, 36, 986710, 60, 55.00, '2011-05-24', '2011-05-24', 'Slow Snail');
