package week2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileLogger implements AutoCloseable {
    private static final DateTimeFormatter TS = DateTimeFormatter.ofPattern("yy.MM.dd - HH:mm:ss");
    private static final Path LOG_PATH = Paths.get("log.txt");

    private final BufferedWriter writer;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public FileLogger() {
        try {
            Path parent = LOG_PATH.getParent();
            if (parent != null) Files.createDirectories(parent);
            this.writer = Files.newBufferedWriter(
                    LOG_PATH,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE
            );
        } catch (IOException e) {
            throw new RuntimeException("Failed to open log file: " + LOG_PATH, e);
        }
    }

    public void log(String message) {
        final String line = "[" + LocalDateTime.now().format(TS) + "] - " + message;
        executor.execute(() -> {
            try {
                writer.write(line);
                writer.newLine();
                writer.flush();
            } catch (IOException e) { // 예외 기록만
                System.err.println("LOG I/O ERROR: " + e.getMessage());
            }
        });
    }

    public void logRound(String message) {
        log("\t" + message);
    }

    @Override
    public void close() {
        executor.shutdown();
    }
}
