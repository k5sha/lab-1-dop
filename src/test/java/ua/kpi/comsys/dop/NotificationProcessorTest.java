package ua.kpi.comsys.dop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationProcessorTest {

    // Creating a mock class for testing
    private final NotificationProcessor processor = new NotificationProcessor();

    @Test
    void testProcessTextMsg() {
        var msg = new Notification.TextMsg("Test", "Hello World!");
        String expected = """
            Notification: TEXT
            From: Test
            Message: Hello World!""";

        assertEquals(expected, processor.process(msg));
    }

    @Test
    void testProcessImageMsg() {
        var msg = new Notification.ImageMsg("Test", "https://test.com/photo.jpg", 1024);
        String expected = """
            Notification: IMAGE
            From: Test
            URL: https://test.com/photo.jpg (1024 KB)""";

        assertEquals(expected, processor.process(msg));
    }

    @Test
    void testProcessAudioMsg() {
        var msg = new Notification.AudioMsg("Test", 45);
        String expected = """
            Notification: AUDIO
            From: Test
            Duration: 45 seconds""";

        assertEquals(expected, processor.process(msg));
    }

    // Testing the exceptions
    @Test
    void testNullNotificationThrowsException() {
        var exception = assertThrows(IllegalArgumentException.class, () -> processor.process(null));
        assertEquals("Notification cannot be null", exception.getMessage());
    }

    @Test
    void testInvalidTextMsgArguments() {
        assertThrows(IllegalArgumentException.class, () -> new Notification.TextMsg(null, "text"));
        assertThrows(IllegalArgumentException.class, () -> new Notification.TextMsg("", "text"));
        assertThrows(IllegalArgumentException.class, () -> new Notification.TextMsg("   ", "text"));
        assertThrows(IllegalArgumentException.class, () -> new Notification.TextMsg("sender", null));
        assertThrows(IllegalArgumentException.class, () -> new Notification.TextMsg("sender", ""));
        assertThrows(IllegalArgumentException.class, () -> new Notification.TextMsg("sender", "   "));
    }

    @Test
    void testInvalidImageMsgArguments() {
        assertThrows(IllegalArgumentException.class, () -> new Notification.ImageMsg(null, "url", 100));
        assertThrows(IllegalArgumentException.class, () -> new Notification.ImageMsg("", "url", 100));
        assertThrows(IllegalArgumentException.class, () -> new Notification.ImageMsg("   ", "url", 100));
        assertThrows(IllegalArgumentException.class, () -> new Notification.ImageMsg("sender", null, 100));
        assertThrows(IllegalArgumentException.class, () -> new Notification.ImageMsg("sender", "", 100));
        assertThrows(IllegalArgumentException.class, () -> new Notification.ImageMsg("sender", "   ", 100));
        assertThrows(IllegalArgumentException.class, () -> new Notification.ImageMsg("sender", "url", 0));
        assertThrows(IllegalArgumentException.class, () -> new Notification.ImageMsg("sender", "url", -10));
    }

    @Test
    void testInvalidAudioMsgArguments() {
        assertThrows(IllegalArgumentException.class, () -> new Notification.AudioMsg(null, 10));
        assertThrows(IllegalArgumentException.class, () -> new Notification.AudioMsg("", 10));
        assertThrows(IllegalArgumentException.class, () -> new Notification.AudioMsg("   ", 10));
        assertThrows(IllegalArgumentException.class, () -> new Notification.AudioMsg("sender", 0));
        assertThrows(IllegalArgumentException.class, () -> new Notification.AudioMsg("sender", -5));
    }
}