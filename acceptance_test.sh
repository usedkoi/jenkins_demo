#!/usr/bin/bash
test $(curl localhost:8081/sum?a=10&b=30) -eq 40
test $(curl localhost:8081/?data=10) -eq 55