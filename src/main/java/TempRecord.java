public class TempRecord {

    private int recordId;
    private double temperature;
    private int unitId;

    public TempRecord() {
    }

    public TempRecord(int recordId,
                      double temperature,
                      int unitId) {

        this.recordId = recordId;
        this.temperature = temperature;
        this.unitId = unitId;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }
}