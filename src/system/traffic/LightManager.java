package system.traffic;

import system.traffic.states.Red;
import system.traffic.states.State;

/**
 * Component to take care of managing the states - Red, Green, Yellow
 */
public final class LightManager {
    private State state;

    public LightManager(State state) {
        this.state = state;

        if (this.state == null) {
            this.state = Red.getInstance();
        }
    }

    public State getState() {
        return this.state;
    }

    public synchronized void setState(State state) {
        this.state = state;
    }

    public synchronized void update() {
        this.state.update(this);
    }
}
