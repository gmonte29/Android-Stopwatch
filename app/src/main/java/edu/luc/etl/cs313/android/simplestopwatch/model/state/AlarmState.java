package edu.luc.etl.cs313.android.simplestopwatch.model.state;
import edu.luc.etl.cs313.android.simplestopwatch.R;

/**
 * Timer state when timer counts down all the way to zero.
 *
 * @author Team 1
 */
class AlarmState implements TimerState {

    public AlarmState(final TimerSMStateView sm) {
        this.sm = sm;
    }

    //Counter to play alarm every 3 seconds.
    private int counter=0;

    private final TimerSMStateView sm;

    @Override
    public void onMultiButton() {
        //Resets display to 0
        sm.actionReset();

        //Stops clock from ticking
        sm.actionStop();

        //Sets counter to 1 so that alarm doesn't play in OnTick()
        counter=1;

        //Moves us to the stopped state
        sm.toStoppedState();

    }

    //Clock ticks play alarm every 3 seconds.
    @Override
    public void onTick() {
        //One time alarm as soon as alarm state is set.  This is to avoid 3 second delay when first transitioning from Increment to Alarm state.
        if(counter==0){sm.playAlarm();}

        counter++;

        //Plays the alarm every 3 seconds
        if(counter%3==0){sm.playAlarm();}
    }


    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.ALARM;
    }
}
