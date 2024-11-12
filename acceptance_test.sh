#!/usr/bin/bash
test "$(curl -s 'http://localhost:8081?a=1&b=2')" -eq 2
if [ $? -eq 0 ]; then
    echo "Test passed"
else
    echo "Test failed"
    exit 1
fi