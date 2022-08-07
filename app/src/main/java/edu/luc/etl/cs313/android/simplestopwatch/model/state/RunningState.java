package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class RunningState implements TimerState {

    public RunningState(final TimerSMStateView sm) {
        this.sm = sm;
    }

    private final TimerSMStateView sm;

    @Override
    public void onStartStop() {
        //Stops the clock
        sm.actionStop();

        //Transitions us to the stopped state
        sm.toStoppedState();

        //Resets the display time to 0
        sm.actionReset();
    }


    @Override
    public void onTick() {
        //Decrements the display time by 1 seconds every tick
        sm.actionDec();

        //When display time equals 0, transition to the alarm state
        if(sm.actionReturn()==0){
            sm.toAlarmState();
        }

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
