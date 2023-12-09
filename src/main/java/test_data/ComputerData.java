package test_data;

public class ComputerData {
    private String processor;
    private String ram;
    private String os;
    private String hdd;
    private String software;

    public ComputerData(String processor, String ram, String os, String hdd, String software) {
        this.processor = processor;
        this.ram = ram;
        this.os = os;
        this.hdd = hdd;
        this.software = software;
    }

    public String getProcessor() {
        return processor;
    }

    public String getRam() {
        return ram;
    }

    public String getOs() {
        return os;
    }

    public String getHdd() {
        return hdd;
    }

    public String getSoftware() {
        return software;
    }

    @Override
    public String toString() {
        return "ComputerData{" +
                "processor='" + processor + '\'' +
                ", os='" + os + '\'' +
                ", hdd='" + hdd + '\'' +
                ", software='" + software + '\'' +
                ", processor='" + processor + '\'' +
                "}";
    }
}
