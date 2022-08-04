package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class AlarmState implements StopwatchState {

    public AlarmState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final StopwatchSMStateView sm;

    @Override
    public void onStartStop() {
        sm.actionStart();
        sm.toIncrementState();
    }

    /*
    @Override
    public void onLapReset() {
        sm.toStoppedState();
        sm.actionUpdateView();
    }

     */

    @Override
    public void onTick() {
        throw new UnsupportedOperationException("onTick");
    }

    //Old Version being commented out.  We likely have to update the regular UIruntime.  I'll do that below it.
    /*
    @Override
    public void updateView() {
        sm.updateUILaptime();
    }
     */

    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.ALARM;
    }
}
