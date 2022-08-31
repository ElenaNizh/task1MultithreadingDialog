
class MyThread extends Thread {

    private final int sleepTimeThread = 3000;


    //Напишите свой собственный класс-поток MyThread или иное название,
    // который переопределит метод run таким образом,
    // чтобы раз в несколько секунд печатать сообщение в консоль.
    @Override
    public void run() {
        try {
            while (true) {
                if (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Всем привет от потока " + Thread.currentThread().getName());
                    Thread.sleep(sleepTimeThread);
                }
            }
            //Используйте метод Thread.getCurrentThread.getName() для получения имени текущего потока.
        } catch (InterruptedException e) {
            System.out.println("Поток " + Thread.currentThread().getName() + " хотят прервать");
        } finally {
            System.out.println("Поток " + Thread.currentThread().getName() + " завершен\n");
        }
    }
}