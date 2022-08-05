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
//        sm.actionStart();
//        sm.toIncrementState();
        //Method to stop alarm

        sm.actionStop();
        counter=1;
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
        counter++;
        if(counter%2==0){sm.playAlarm();}

//        while(alarmOn){
//             sm.playAlarm();
//
//             alarmOn=false;
//
//            //TimeUnit.SECONDS.sleep(1);
//        }
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
