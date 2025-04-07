package utils;

public class Timer {
    private long startTime, endTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
    }

    public long getElapsedTime() {
        return (endTime - startTime) / 1_000_000; // Convert to milliseconds
    }
}