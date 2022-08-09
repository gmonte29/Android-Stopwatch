package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

/**
 * Timer state when timer reaches 0 and is not in alarm state.
 *
 * @author Team 1
 */

class StoppedState implements TimerState {

    public StoppedState(final TimerSMStateView sm) {
        this.sm = sm;
    }

    private final TimerSMStateView sm;

    @Override
    public void onMultiButton() {

        //Start the clock
        sm.actionStart();

        //Increment display time to 1
        sm.actionInc();

        //Transition to the increment state
        sm.toIncrementState();
    }

    @Override
    public void onTick() {
        throw new UnsupportedOperationException("onTick");
    }

    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.STOPPED;
    }
}
