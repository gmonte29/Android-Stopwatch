package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class IncrementState implements StopwatchState {

    public IncrementState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final StopwatchSMStateView sm;

    private int counter=0;
    @Override
    public void onStartStop() {

        // Changed from "sm.actionStop();"
        sm.actionInc();
        counter=0;


        //Ryan's previous thought on how to handle clicks and transitioning to the running state.
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
        //sm.actionInc();
        //sm.toIncrementState();
        counter++;
        if(counter==3||sm.actionReturn()==99){
            sm.toRunningState();
        };
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
