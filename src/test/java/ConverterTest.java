import java.util.Random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by m0x35 on 2/16/17.
 */
public class ConverterTest {
    Random r = new Random();

    @Test
    public void bytesTest() {
        long val = r.nextLong();

        byte bytes[] = Converter.longToBytes(val);

        long res = Converter.bytesToLong(bytes);

        assertEquals(val, res);
    }

    @Test
    public void conversationTest() {
        GpsCoordinate val = new GpsCoordinate(r.nextDouble(), r.nextDouble());

        String base64 = Converter.toBase64(val);
        GpsCoordinate res = Converter.fromBase64(base64);

        assertEquals(val.equals(res), true);
    }

    @Test
    public void conversationBytesTest() {
        GpsCoordinate val = new GpsCoordinate(r.nextDouble(), r.nextDouble());

        byte bytes[] = Converter.toBytes(val);
        GpsCoordinate res = Converter.fromBytes(bytes);

        assertTrue(val.equals(res));
    }
}
