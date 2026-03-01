public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { 
        this.reg = reg; 
    }

    public void startClass() {
        reg.getDevice(IPowerControl.class).powerOn();
        reg.getDevice(IConnectInput.class).connectInput("HDMI-1");

        reg.getDevice(IBrightnessControl.class).setBrightness(60);

        reg.getDevice(ITemperatureControl.class).setTemperatureC(24);

        int present = reg.getDevice(IAttendanceScanner.class).scanAttendance();

        System.out.println("Attendance scanned: present=" + present);
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        reg.getDevice(Projector.class).powerOff();
        reg.getDevice(LightsPanel.class).powerOff();
        reg.getDevice(AirConditioner.class).powerOff();
    }
}
