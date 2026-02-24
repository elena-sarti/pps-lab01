package tdd;

public class DoorLock implements SmartDoorLock{
    private static final int PIN_DIGITS = 4;
    private static final int MAXIMUM_NUMBER_OF_UNLOCKING_ATTEMPTS = 5;
    public static String pin;
    private static boolean isDoorLocked = false;
    private static boolean isDoorBlocked = false ;
    private static int numberOfFailedAttempts;

    @Override
    public void setPin(String pin) {
        if ( pin.length() != PIN_DIGITS) { return; }
        if ( isDoorLocked || isDoorBlocked ) { return; }
        this.pin = pin;
    }

    @Override
    public void unlock(String pin) {
        if ( pin.equals(this.pin) ) {
            isDoorLocked = false;
        } else {
            numberOfFailedAttempts += 1;
            isDoorBlocked = numberOfFailedAttempts < MAXIMUM_NUMBER_OF_UNLOCKING_ATTEMPTS ? false : true;
        }
    }

    @Override
    public void lock() {
        if ( this.pin == null ) { throw new IllegalStateException("Pin not set yet."); }
        isDoorLocked = true;
    }

    @Override
    public boolean isLocked() {
        return isDoorLocked;
    }

    @Override
    public boolean isBlocked() {
        return isDoorBlocked;
    }

    @Override
    public int getMaxAttempts() {
        return MAXIMUM_NUMBER_OF_UNLOCKING_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return numberOfFailedAttempts;
    }

    @Override
    public void reset() {
        pin = null;
        isDoorLocked = false;
        isDoorBlocked = false;
        numberOfFailedAttempts = 0;
    }

}
