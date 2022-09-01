import java.util.concurrent.Callable;

//Используйте Callable для создания задач, возвращающих результат.
class MyThread implements Callable<String> {
    private String name;
    private final int sleepTimeThread = 3000;
    private int numberOfMessages = 0;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public String call() {
        Thread.currentThread().setName(name);
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Всем Привет от потока " + Thread.currentThread().getName());
                numberOfMessages++;
                Thread.sleep(sleepTimeThread);
            }
        } catch (InterruptedException e) {
            System.out.println("Поток " + Thread.currentThread().getName() + " хотят прервать");
        } finally {
            System.out.println("Поток " + Thread.currentThread().getName() + " завершен");
        }
        return "    - Потоком " + Thread.currentThread().getName() + " количество сообщений: " + numberOfMessages;
    }
}