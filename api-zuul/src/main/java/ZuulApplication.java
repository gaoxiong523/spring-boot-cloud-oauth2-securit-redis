import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author gaoxiong
 * @ClassName ZuulApplication
 * @Description TODO
 * @date 2019/7/1 11:40
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZuulApplication {
    public static void main ( String[] args ) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
