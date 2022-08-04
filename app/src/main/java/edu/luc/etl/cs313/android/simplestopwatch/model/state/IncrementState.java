package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class IncrementState implements StopwatchState {

    public IncrementState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final StopwatchSMStateView sm;

    @Override
    public void onStartStop() {
        sm.actionStop();

//       sm.toAlarmState();
//        if(ticks<3){
//        runningtime++;
//        while(ticks<3){
//            ticks++;
//        }
//        else sm.runningState();}

    }

    /*
    @Override
    public void onLapReset() {
        sm.toRunningState();
        sm.actionUpdateView();
    }

     */

    @Override
    public void onTick() {
        sm.actionInc();
        sm.toIncrementState();
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
        return R.string.INCREMENT;
    }
}
