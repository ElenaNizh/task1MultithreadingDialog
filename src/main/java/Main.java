import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

// Используйте Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()) для создания пула потоков.
        final ExecutorService threads = Executors.newFixedThreadPool(4);
        final int sleepTime = 15_000;

        System.out.println("Создаю потоки...");

        final List<Future<String>> task = new ArrayList<>();
//Используйте методы submit()
// или invokeAll для исполнения всех задач и метод invokeAny для получения результата одной из них (самой быстрой)
        task.add(threads.submit(new MyThread("Один")));
        task.add(threads.submit(new MyThread("Два")));
        task.add(threads.submit(new MyThread("Три")));
        task.add(threads.submit(new MyThread("Четыре")));

        Thread.sleep(sleepTime);
        threads.shutdownNow();

        for (Future<String> future : task) {
            try {
                System.out.println(future.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

