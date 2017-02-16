/**
 * Created by m0x35 on 2/16/17.
 */
public class GpsCoordinate {
    public final double longitude;
    public final double latitude;


    public GpsCoordinate(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object obj) {
        boolean ret = super.equals(obj);

        if (obj.getClass() == GpsCoordinate.class) {
            GpsCoordinate gobj = (GpsCoordinate) obj;
            ret = this.longitude == gobj.longitude && this.latitude == gobj.latitude;
        }

        return ret;
    }
}
