package ua.kpi.comsys.dop;


public sealed interface Notification permits Notification.TextMsg, Notification.ImageMsg, Notification.AudioMsg {

    record TextMsg(String sender, String text) implements Notification {
        public TextMsg {
            if (sender == null || sender.isBlank() || text == null || text.isBlank()) {
                throw new IllegalArgumentException("Sender and text cannot be null or blank");
            }
        }
    }

    record ImageMsg(String sender, String url, int sizeKb) implements Notification {
        public ImageMsg {
            if (sender == null || sender.isBlank() || url == null || url.isBlank()) {
                throw new IllegalArgumentException("Sender and url cannot be null or blank");
            }
            if (sizeKb <= 0) {
                throw new IllegalArgumentException("sizeKb must be greater than 0");
            }
        }
    }

    record AudioMsg(String sender, int durationSeconds) implements Notification {
        public AudioMsg {
            if (sender == null || sender.isBlank()) {
                throw new IllegalArgumentException("Sender cannot be null or blank");
            }
            if (durationSeconds <= 0) {
                throw new IllegalArgumentException("durationSeconds must be greater than 0");
            }
        }
    }
}