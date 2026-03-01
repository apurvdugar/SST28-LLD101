import java.util.*;

public class DeviceRegistry {

    private final List<Object> devices = new ArrayList<>();

    public void add(Object d){
        devices.add(d);
    }

    public <T> T getDevice(Class<T> capability) {
        for (Object d : devices) {
            if (capability.isInstance(d)) 
                return capability.cast(d);
        }
        throw new IllegalStateException("Missing: " + capability.getSimpleName());
    }

    // private final java.util.List<SmartClassroomDevice> devices = new ArrayList<>();

    // public void add(SmartClassroomDevice d) { devices.add(d); }

    // public SmartClassroomDevice getFirstOfType(String simpleName) {
    //     for (SmartClassroomDevice d : devices) {
    //         if (d.getClass().getSimpleName().equals(simpleName)) return d;
    //     }
    //     throw new IllegalStateException("Missing: " + simpleName);
    // }
}
