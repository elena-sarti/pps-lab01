package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    private static final String CORRECT_PIN = "0000";
    public static final String INCORRECT_PIN = "1111";
    DoorLock doorLock;

    @BeforeEach
    void beforeEach(){
        doorLock = new DoorLock();
        doorLock.setPin(CORRECT_PIN);
    }

    @Test
    void canPinBeSet(){
        assertNotNull(doorLock.pin);
    }

    @Test
    void canDoorBeLocked(){
        doorLock.lock();
        assertTrue(doorLock.isLocked());
    }

    @Test
    void canDoorBeLockedIfPinNotSet(){
        doorLock.reset();
        assertThrows(IllegalStateException.class, () -> doorLock.lock());
    }

    @Test
    void canDoorBeUnlockedRightPin(){
        doorLock.lock();
        doorLock.unlock(CORRECT_PIN);
        assertFalse(doorLock.isLocked());
    }

    @Test
    void canDoorBeUnlockedWrongPin(){
        doorLock.lock();
        doorLock.unlock(INCORRECT_PIN);
        assertTrue(doorLock.isLocked());
    }

    @Test
    void canDoorBeBlocked(){
        doorLock.lock();
        for(int numberOfAttempts = 0; numberOfAttempts < doorLock.getMaxAttempts(); numberOfAttempts++){ doorLock.unlock(INCORRECT_PIN); }
        assertTrue(doorLock.isBlocked());
    }

    @Test
    void canDoorBeResetted(){
        doorLock.lock();
        for(int numberOfAttempts = 0; numberOfAttempts < doorLock.getMaxAttempts(); numberOfAttempts++){ doorLock.unlock(INCORRECT_PIN); }
        doorLock.reset();
        assertFalse(doorLock.isLocked());
        assertFalse(doorLock.isBlocked());
        assertNull(doorLock.pin);
        assertEquals(0, doorLock.getFailedAttempts());
    }
}
