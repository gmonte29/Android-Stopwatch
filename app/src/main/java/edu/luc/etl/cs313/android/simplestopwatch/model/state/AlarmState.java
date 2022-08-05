package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class AlarmState implements StopwatchState {

    public AlarmState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private boolean alarmOn=true;
    private final StopwatchSMStateView sm;

    @Override
    public void onStartStop() {
        sm.actionReset();
//        sm.actionStart();
//        sm.toIncrementState();
        //Method to stop alarm
        alarmOn=false;
        sm.actionStop();
        sm.toStoppedState();
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

        if(alarmOn){
            //running alarm
        }
        //Sound the alarm with alternate sound at every tick.
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
