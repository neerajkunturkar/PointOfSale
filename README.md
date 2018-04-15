# PointOfSale
A simple web-application for retail store check-out counter

This RESTful application is built using Sprint-Boot.

Simple model structure:
    Product
      | Product-SKU1
          | Product-Upc1
          | Product-Upc2
          | Product-Upc3
      | Product-SKU2
          | Product-Upc21
      | Product-SKU3
      
   Cart
      | CartProductDetail1
      | CartProductDetail2
      | CartProductDetail3
      
In this application each user is authenticated using spring jwt authentication. After successful authentication, the token is validated before using any of the service. If the token provided is invalid, then the user is not restricted to use the rest services.

1. To setup the project for Idea:
	Windows - gradlew.bat cleanIdea idea

2. To setup the project for Eclipse
	Windows - gradlew.bat eclipse
