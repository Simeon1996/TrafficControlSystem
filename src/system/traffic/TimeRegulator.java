package system.traffic;

import system.traffic.states.Red;
import system.traffic.states.State;
import system.traffic.states.Yellow;

import java.util.concurrent.TimeUnit;

/**
 * A test class to test switching the states
 * with one simple goal - to regulate how much seconds each light will be on focus
 */
public class TimeRegulator {

    private LightManager manager;

    public TimeRegulator(LightManager manager) {
        this.manager = manager;
    }

    /**
     * Logic to regulate the lights and their durations
     */
    public synchronized void execute() throws InterruptedException {
        // Condition may be applied. E.g. turn off the traffic control system after 9PM.
        // so we can place the thread in waiting state and notify it again after 6 AM.
        while (true) {
            final State state = manager.getState();
            final int duration = getDuration(state);

            System.out.println(state);
            for (int i = duration; i >= 0; i--) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }

            manager.update();
        }
    }

    /**
     * Get duration of the specified State
     *
     * @param state represents the possible lights
     *
     * @return int value
     */
    private int getDuration(State state) {
        int duration;

        if (state == Red.getInstance()) {
            duration = LightDuration.RED.getValue();
        } else if (state == Yellow.getInstance()) {
            duration = LightDuration.YELLOW.getValue();
        } else {
            duration = LightDuration.GREEN.getValue();
        }

        return duration;
    }
}
