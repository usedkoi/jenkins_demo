package ajou.usedkoi.jenkins_demo;

public class JenkinsService {
    public int  hap(int n){
        int result =0;
        for(int i=0;i<n;i++){
            result += i;
        }
        return result;
    }
}