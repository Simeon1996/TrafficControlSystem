package system.traffic.states;

import system.traffic.LightManager;

public class Red implements State {
    private static Red instance = new Red();

    private Red() {}

    public static Red getInstance() {
        return instance;
    }

    @Override
    public void update(LightManager lightManager) {
        lightManager.setState(Green.getInstance());
    }

    @Override
    public String toString() {
        return "Red";
    }
}
