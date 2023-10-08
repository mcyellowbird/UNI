Powershell:
	run command: wsl

To start the server:
	sudo service redis-server start
	
To connect to the server:
	redis-cli
	
Test set and get:
	SET vNum 1.4
	GET vNum

Run redis.js then:
	GET baseCost
	GET test