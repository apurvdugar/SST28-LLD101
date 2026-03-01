public class Projector implements IPowerControl, IConnectInput {
    private boolean on;

    @Override 
    public void powerOn() { 
        on = true; 
    }
    @Override 
    public void powerOff() { 
        on = false; 
        System.out.println("Projector OFF"); 
    }

    // removed irrelevant methods not required in this class

    @Override 
    public void connectInput(String port) { 
        if (on) System.out.println("Projector ON (" + port + ")"); 
    }
}
