package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;
import edu.luc.etl.cs313.android.simplestopwatch.common.Constants;

class IncrementState implements TimerState {

    public IncrementState(final TimerSMStateView sm) {
        this.sm = sm;
    }

    private final TimerSMStateView sm;

    //Counter variable to determine when to move to running state.
    private int counter=0;


    @Override
    public void onMultiButton() {

        //Condition to keep display time between 0 and 99.
        if(sm.actionReturn() > 0 && sm.actionReturn() < Constants.SEC_MAX) {

            sm.actionInc();

            //Resets counter to 0 every time clock is incremented by multi-button click.
            counter = 0;

        }
    }


    @Override
    public void onTick() {
        counter++;

        //If the display is at 99, then the onTick method is stopped and object moved to running state
        if(sm.actionReturn()==99) {

            //Plays audible alert informing the user that the timer is now about to move to the running state and start counting down.
            sm.playAlarm();

            //Moves us to the running state
            sm.toRunningState();

        }
        //Moves to running state if 3 seconds has passed since last multi-button push or display time is set to 99 seconds.
        else if(counter==3){

            //Plays audible alert informing the user that the timer is now about to move to the running state and start counting down.
            sm.playAlarm();

            //Moves us to the running state
            sm.toRunningState();
        }
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
