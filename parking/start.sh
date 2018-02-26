#!/bin/bash

trap cleanup 2 

cleanup()
{
	cd ..
	mvn clean
}

if [ -d target ]; then
	cd target
	if [ -f pidFile.txt ]; then 
		echo "File found!"
		line=$(head -n 1 pidFile.txt)
		taskkill //PID $line //F
		cd ..
	else 
		echo "File not found"
		cd ..
	fi
fi
mvn clean
mvn install
if [ -d target ]; then
	cd target
	java -jar parking-0.0.1.jar
else
	echo "Error, there is no jar file"
fi



