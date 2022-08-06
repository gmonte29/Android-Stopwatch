package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

import java.util.concurrent.TimeUnit;



class AlarmState implements StopwatchState {

    public AlarmState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private int counter=0;
    private boolean alarmOn=true;
    private final StopwatchSMStateView sm;

    @Override
    public void onStartStop() {
        sm.actionReset();
        sm.actionStop();
        counter=1;
        sm.toStoppedState();

    }


    @Override
    public void onTick() {
        counter++;
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
