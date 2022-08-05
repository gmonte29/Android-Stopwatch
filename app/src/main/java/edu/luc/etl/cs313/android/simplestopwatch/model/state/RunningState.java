package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class RunningState implements StopwatchState {

    public RunningState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final StopwatchSMStateView sm;

    @Override
    public void onStartStop() {

        sm.actionStop();
        sm.toStoppedState();
        sm.actionReset();
    }

    /*
    @Override
    public void onLapReset() {
        sm.actionLap();
        sm.toLapRunningState();
    }

     */

    @Override
    public void onTick() {
        sm.actionDec();

        if(sm.actionReturn()==0){
            sm.toAlarmState();
        }
        //sm.toRunningState();
    }

    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.RUNNING;
    }
}
