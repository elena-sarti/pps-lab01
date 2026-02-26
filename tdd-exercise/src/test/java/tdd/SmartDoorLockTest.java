package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    private static final String CORRECT_PIN = "0000";
    public static final String INCORRECT_PIN = "1111";
    DoorLock doorLock;

    @BeforeEach
    public void beforeEach(){
        doorLock = new DoorLock();
        doorLock.setPin(CORRECT_PIN);
    }

    @Test
    public void testSetPin(){
        assertNotNull(doorLock.pin);
    }

    @Test
    public void testLock(){
        doorLock.lock();
        assertTrue(doorLock.isLocked());
    }

    @Test
    public void testLockPinNotSet(){
        doorLock.reset();
        assertThrows(IllegalStateException.class, () -> doorLock.lock());
    }

    @Test
    public void testUnlockRightPin(){
        doorLock.lock();
        doorLock.unlock(CORRECT_PIN);
        assertFalse(doorLock.isLocked());
    }

    @Test
    public void testUnlockWrongPin(){
        doorLock.lock();
        doorLock.unlock(INCORRECT_PIN);
        assertTrue(doorLock.isLocked());
    }

    @Test
    public void testBlock(){
        doorLock.lock();
        blockingDoor();
        assertTrue(doorLock.isBlocked());
    }

    @Test
    public void testUnlockWhenBlocked(){
        doorLock.lock();
        blockingDoor();
        assertThrows(IllegalStateException.class, () -> doorLock.unlock(CORRECT_PIN) );
    }

    @Test
    public void testReset(){
        doorLock.lock();
        blockingDoor();
        doorLock.reset();
        assertFalse(doorLock.isLocked());
        assertFalse(doorLock.isBlocked());
        assertNull(doorLock.pin);
        assertEquals(0, doorLock.getFailedAttempts());
    }

    public void blockingDoor(){
        for(int numberOfAttempts = 0; numberOfAttempts < doorLock.getMaxAttempts(); numberOfAttempts++){ doorLock.unlock(INCORRECT_PIN); }
    }
}
