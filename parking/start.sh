#!/bin/bash
mvn clean
mvn install
cd target
java -jar parking-0.0.1.jar