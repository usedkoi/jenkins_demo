package ajou.usedkoi.jenkins_demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class jenkins_demoTest {
    private JenkinsService service = new JenkinsService();

    @Test
    public void testService() {
        assertEquals( 55, service.hap(10));

    }
}