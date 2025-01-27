import java.util.List;

public class MultiExecutor {

    private List<Runnable> tasks;

    // Add any necessary member variables here

    /*
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
        this.tasks = tasks;
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        if (tasks != null) {
            tasks.stream().map(Thread::new).forEach(Thread::run);
        }
    }
}
