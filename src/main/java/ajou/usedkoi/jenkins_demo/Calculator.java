package ajou.usedkoi.jenkins_demo;

import org.springframework.stereotype.Service;

@Service
public class Calculator {
    public int sum(int a, int b){
        return a + b;
    }

    public int product(int a, int b){
        return a * b;
    }
}
