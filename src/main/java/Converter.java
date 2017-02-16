import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Created by m0x35 on 2/16/17.
 */
public class Converter {

    public static GpsCoordinate fromBase64(String str) {
        GpsCoordinate res;

        try {
            byte data[] = Base64.decode(str);
            res = fromBytes(data);
        } catch (Throwable e) {
            //not sure maybe it's better to throw an exception
            res = new GpsCoordinate(0.0, 0.0);
        }

        return res;
    };

    public static String toBase64(GpsCoordinate data) {
        return Base64.encode(toBytes(data));
    }

    static GpsCoordinate fromBytes(byte data[]) throws IndexOutOfBoundsException {

        byte longitudeArr[] = new byte[Long.BYTES];
        byte latitudeArr[] = new byte[Long.BYTES];

        System.arraycopy(data, 0, longitudeArr, 0, Long.BYTES);
        System.arraycopy(data, Long.BYTES, latitudeArr, 0, Long.BYTES);

        double longitude = Double.longBitsToDouble(bytesToLong(longitudeArr));
        double latitude = Double.longBitsToDouble(bytesToLong(latitudeArr));

        return new GpsCoordinate(longitude, latitude);
    };

    static byte[] toBytes(GpsCoordinate data) {
        byte bytes[] = new byte[Long.BYTES<<1];

        byte longitudeArr[] = longToBytes(Double.doubleToLongBits(data.longitude));
        byte latitudeArr[] = longToBytes(Double.doubleToLongBits(data.latitude));

        System.arraycopy(longitudeArr, 0, bytes, 0, Long.BYTES);
        System.arraycopy(latitudeArr, 0, bytes, Long.BYTES, Long.BYTES);

        return bytes;
    }

    static long bytesToLong(byte bytes[]) throws IndexOutOfBoundsException {
        long res = 0;

        for (int i = 0; i < Double.BYTES; i++) {
            System.out.println();
            res = res<<8 | Byte.toUnsignedLong(bytes[i]);
        }

        return res;
    }

    static byte[] longToBytes(long val) {
        byte res[] = new byte[Double.BYTES];

        for (int i = 0; i < Double.BYTES; i++) {
            res[Long.BYTES - i - 1] = (byte) (val>>i*8);
        }

        return res;
    }
}
