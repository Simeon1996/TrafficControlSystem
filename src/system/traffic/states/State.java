package system.traffic.states;

import system.traffic.LightManager;

public interface State {
    void update(LightManager lightManager);
}
