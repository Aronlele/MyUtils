package tk.huclele.util;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/**
 * 单例模式线程池.
 *
 * @author : 薛乐乐
 * @since : 2019/7/11 10:35
 */
public class SingleThreadPool {

  private SingleThreadPool() {
  }

  private static ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(3,
      new DaemonThreadFactory());

  public static ScheduledExecutorService getScheduledExecutorService() {
    return scheduledExecutorService;
  }

  static final class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
      Thread t = new Thread(r);
      t.setDaemon(true);
      t.setName("CompletableFutureDelayScheduler");
      return t;
    }
  }

}
