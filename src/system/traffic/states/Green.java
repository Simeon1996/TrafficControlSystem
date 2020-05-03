package system.traffic.states;

import system.traffic.LightManager;

public class Green implements State {
    private static Green instance = new Green();

    private Green() {}

    public static Green getInstance() {
        return instance;
    }

    @Override
    public void update(LightManager lightManager) {
        lightManager.setState(Yellow.getInstance());
    }

    @Override
    public String toString() {
        return "Green";
    }
}
