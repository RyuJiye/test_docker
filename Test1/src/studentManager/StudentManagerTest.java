package studentManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentManagerTest {
	
	StudentManager sm;

	@BeforeEach
	void setUp() throws Exception {
		sm = new StudentManager();
	}

	@Test
	void testAddStudent() {
		sm.addStudent("Student1");
		assertTrue(sm.hasStudent("Student1"));
	}

	@Test
	void testRemoveStudent() {
		sm.addStudent("Student1");
		sm.removeStudent("Student1");
		assertFalse(sm.hasStudent("Student1"));
	}

	@Test
	void testAddDuplicateStudent() {
		sm.addStudent("Student1");
		assertThrows(IllegalArgumentException.class, () -> {
	        sm.addStudent("Student1");
	    });
	}

	@Test
	void testRemoveNonExistStudent() {
		assertThrows(IllegalArgumentException.class, () -> {
	        sm.removeStudent("Student1");
	    });
	}
}
