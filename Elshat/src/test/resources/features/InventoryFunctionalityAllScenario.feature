@UPGN-363
Feature: Default

	#As a PosManager, I should be able to check and edit the Inventory of the company. So that I can list all products in the company, I can add new products to inventory, I can select the Product type, I can set prices (cost & sales), I can give a barcode to the product. I can set a product picture.
	@UPGN-362
	Scenario: Elshat_Inventory_Functionality:Posmanager do all steps in one shot
		When User login for testing other functionality
		    When  Posmanager click the inventory button
		    When  Posmanager click the product button
		    And   Posmanager click the create button
		    Then  Posmanager give the product name
		    When  Posmanager select the product type
		    Then  Posmanager select the category
		    Then  Posmanager give the internal reference code
		    Then  Posmanager can give a barcode number to product
		    Then  Posmanager set the sales price
		    Then  Posmanager set the cost price
		    Then  Posmanager click the save button
		    Then  Posmanager should see the product created	

	#As a PosManager, I should be able to check and edit the Inventory of the company. So that I can list all products in the company, I can add new products to inventory, I can select the Product type, I can set prices (cost & sales), I can give a barcode to the product. I can set a product picture.
	@UPGN-364
	Scenario: Elshat-Posmanager search the new product that created
		When User login for testing other functionality
		    Then  Posmanager click the inventory button
		    Then  Posmanager click the product button
		    Then  Posmanager search the product that created