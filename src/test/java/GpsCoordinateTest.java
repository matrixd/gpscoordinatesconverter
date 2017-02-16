import java.util.Random;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Created by m0x35 on 2/17/17.
 */
public class GpsCoordinateTest {
    Random r = new Random();

    @Test
    public void testEquals() {
        double longitude = r.nextDouble();
        double latitude = r.nextDouble();

        GpsCoordinate val1 = new GpsCoordinate(longitude, latitude);
        GpsCoordinate val2 = new GpsCoordinate(longitude, latitude);

        assertEquals(val1.equals(val2), true);
    }
}
