package edu.luc.etl.cs313.android.simplestopwatch.model.state;

/**
 * The restricted view states have of their surrounding state machine.
 * This is a client-specific interface in Peter Coad's terminology.
 *
 * @author Team 1
 */
interface TimerSMStateView {

    // transitions
    void toRunningState();
    void toStoppedState();
    void toIncrementState();
    void toAlarmState();

    // actions
    void actionInit();
    void actionReset();
    void actionStart();
    void actionStop();
    void actionInc();
    void actionDec();
    void actionUpdateView();

    // state-dependent UI updates
    void updateUIRuntime();
    int actionReturn();

    //Plays alarm
    void playAlarm();
}
