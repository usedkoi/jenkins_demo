package ajou.usedkoi.jenkins_demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class jenkins_demoTest {
    //테스트할 메서드를 가진 클래스를 가져오기
    private JenkinsService service = new JenkinsService();

    @Test
    public void testService(){
        assertEquals(55, service.hap(10));
    }
}

// hook trigger 02