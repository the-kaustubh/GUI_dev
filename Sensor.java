public class Sensor {
    private String UID;
    private String Location;
    private double setCO2_min, setCO2_max;
    private double setTEMP_min, setTEMP_max;
    private double co2, temperature;
    private boolean status;

    public Sensor(String uid, String Loc) {
        this.UID = uid;
        this.Location = Loc;
        this.setCO2_min = 0;
        this.setCO2_max = 0;
        this.setTEMP_min = 0;
        this.setTEMP_max = 0;
        this.co2 = 0;
        this.temperature = 0;
        this.status = true;
    }

    public String getUID() {
        return this.UID;
    }

    public String getLocation() {
        return this.Location;
    }

    public double getSetCO2_min() {
        return this.setCO2_min;
    }


}