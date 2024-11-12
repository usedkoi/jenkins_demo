#!/usr/bin/bash
test $(curl http://localhost:8081?a=1\&b=2) -eq 3