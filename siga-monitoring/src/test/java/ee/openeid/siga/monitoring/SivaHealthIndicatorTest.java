package ee.openeid.siga.monitoring;

import ee.openeid.siga.common.configuration.SivaClientConfigurationProperties;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class SivaHealthIndicatorTest {

    @InjectMocks
    private SivaHealthIndicator healthIndicator;

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private SivaClientConfigurationProperties configProperties;

    @Before
    public void init() {
        Mockito.when(restTemplate.getForObject(anyString(), any())).thenReturn(new SivaHealthIndicator.HealthStatus("UP"));
    }

    @Test
    public void sivaIsUp() {
        Health health = healthIndicator.health();
        assertEquals(Status.UP, health.getStatus());
    }

    @Test
    public void sivaIsDown() {
        Mockito.when(restTemplate.getForObject(anyString(), any())).thenReturn(new SivaHealthIndicator.HealthStatus("DOWN"));
        Health health = healthIndicator.health();
        assertEquals(Status.DOWN, health.getStatus());
    }

    @Test
    public void couldNotConnectToSiva() {
        Mockito.when(restTemplate.getForObject(anyString(), any())).thenThrow(new RuntimeException("Network error"));
        Health health = healthIndicator.health();
        assertEquals(Status.DOWN, health.getStatus());
    }
}
