package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    private static final String CORRECT_PIN = "0000";
    public static final String INCORRECT_PIN = "1111";
    DoorLock doorLock;

    public void blockingDoor(){
        for(int numberOfAttempts = 0; numberOfAttempts < doorLock.getMaxAttempts(); numberOfAttempts++){ doorLock.unlock(INCORRECT_PIN); }
    }

    @BeforeEach
    public void beforeEach(){
        doorLock = new DoorLock();
        doorLock.setPin(CORRECT_PIN);
    }

    @Test
    public void canPinBeSet(){
        assertNotNull(doorLock.pin);
    }

    @Test
    public void canDoorBeLocked(){
        doorLock.lock();
        assertTrue(doorLock.isLocked());
    }

    @Test
    public void canDoorBeLockedIfPinNotSet(){
        doorLock.reset();
        assertThrows(IllegalStateException.class, () -> doorLock.lock());
    }

    @Test
    public void canDoorBeUnlockedRightPin(){
        doorLock.lock();
        doorLock.unlock(CORRECT_PIN);
        assertFalse(doorLock.isLocked());
    }

    @Test
    public void canDoorBeUnlockedWrongPin(){
        doorLock.lock();
        doorLock.unlock(INCORRECT_PIN);
        assertTrue(doorLock.isLocked());
    }

    @Test
    public void canDoorBeBlocked(){
        doorLock.lock();
        blockingDoor();
        assertTrue(doorLock.isBlocked());
    }

    @Test
    public void testUnlockingWhenBlocked(){
        doorLock.lock();
        blockingDoor();
        assertThrows(IllegalStateException.class, () -> doorLock.unlock(CORRECT_PIN) );
    }

    @Test
    public void canDoorBeResetted(){
        doorLock.lock();
        blockingDoor();
        doorLock.reset();
        assertFalse(doorLock.isLocked());
        assertFalse(doorLock.isBlocked());
        assertNull(doorLock.pin);
        assertEquals(0, doorLock.getFailedAttempts());
    }
}
