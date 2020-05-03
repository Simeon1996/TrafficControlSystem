package system.traffic.states;

import system.traffic.LightManager;

public class Yellow implements State {
    private static Yellow instance = new Yellow();

    private Yellow() {}

    public static Yellow getInstance() {
        return instance;
    }

    @Override
    public void update(LightManager lightManager) {
        lightManager.setState(Red.getInstance());
    }

    @Override
    public String toString() {
        return "Yellow";
    }
}
