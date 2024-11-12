#!/usr/bin/bash
test $(curl localhost:8081?a=1\&b=2) -eq 3