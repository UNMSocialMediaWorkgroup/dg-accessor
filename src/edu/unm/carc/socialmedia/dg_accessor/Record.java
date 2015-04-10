package edu.unm.carc.socialmedia.dg_accessor;

/**
 * @author Sixstring982
 * @since 4/12/2015
 */
public class Record {

    final String owner;
    final long time;
    final double longitude;
    final double latitude;
    final double altitude;
    final double xAccel;
    final double yAccel;
    final double zAccel;
    final double xRot;
    final double yRot;
    final double zRot;
    final double light;
    final double pressure;

    public Record(String owner, long time, double longitude, double latitude,
                  double altitude, double xAccel, double yAccel, double zAccel,
                  double xRot, double yRot, double zRot, double light,
                  double pressure) {
        this.owner = owner;
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.xAccel = xAccel;
        this.yAccel = yAccel;
        this.zAccel = zAccel;
        this.xRot = xRot;
        this.yRot = yRot;
        this.zRot = zRot;
        this.light = light;
        this.pressure = pressure;
    }
}
