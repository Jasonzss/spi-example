import com.jason.example.spi.LoggerService;

/**
 * @author Jason
 * @since 2023/08/03 - 22:46
 */
public class TestMain {

    public static void main(String[] args) {
        LoggerService service = LoggerService.getService();
        service.info("info");
        service.debug("debug");
        service.warn("warn");
        service.error("error");
    }
}
