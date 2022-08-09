package edu.luc.etl.cs313.android.simplestopwatch.model.time;

/**
 * The passive data model of the timer.
 * It does not emit any events.
 *
 * @author Team 1
 */
public interface TimeModel {
    void resetRuntime();
    void decRuntime();
    void incRunTime();
    int getRuntime();

}
