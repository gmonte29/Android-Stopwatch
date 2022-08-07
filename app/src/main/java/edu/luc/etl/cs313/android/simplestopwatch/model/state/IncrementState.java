package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class IncrementState implements StopwatchState {

    public IncrementState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final StopwatchSMStateView sm;

    //Counter variable to determine when to move to running state.
    private int counter=0;


    @Override
    public void onMultiButton() {
        sm.actionInc();

        //Resets counter to 0 every time clock is incremented by multi-button click.
        counter=0;
    }


    @Override
    public void onTick() {
        counter++;

        //Moves to running state if 3 seconds has passed since last multi-button push or display time is set to 99 seconds.
        if(counter==3||sm.actionReturn()==99){

            //Plays audible alert informing the user that the timer is now about to move to the running state and start counting down.
            sm.playAlarm();

            //Moves us to the running state
            sm.toRunningState();
        };
    }


    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }


    @Override
    public int getId() {
        return R.string.INCREMENT;
    }
}
