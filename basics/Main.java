import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

  public static void main(String[] args) {

    int dogCount = 1;
    System.out.println("I own " + dogCount + " " + pluralize("dog", dogCount) + ".");

    int catCount = 2;
    System.out.println("I own " + catCount + " " + pluralize("cat", catCount) + ".");

    int turtleCount = 0;
    System.out.println("I own " + turtleCount + " " + pluralize("turtle", turtleCount) + ".");

    System.out.println(flipNHeads(2));

    clock();
  }

  public static String pluralize(String word, int count) {
    if (count == 0 || count > 1) {
      return word + "s";
    } else {
      return word;
    }
  }

  public static String flipNHeads(int n) {
    int flips = 0;
    int headCount = 0;

    while (headCount < n) {
      double rand = Math.random();
      flips++;

      if (rand >= 0.5) {
        headCount++;
        System.out.println("heads");
      } else {
        System.out.println("tails");
        headCount = 0;
      }
    }

    return "It took " + flips + " flips to flip " + headCount + " heads in a row.";
  }

  public static void clock() {
    int timeInterval = 1000;

    // This developers webpage helped me setup a simple thread
    // https://blog.ajduke.in/2014/03/31/java-how-to-schedule-a-task-to-run-in-an-interval/
    Runnable runnable = new Runnable() {
      public void run() {
        while (true) {
          LocalDateTime now = LocalDateTime.now();
          String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
          
          System.out.println(time);

          try {
            Thread.sleep(timeInterval);
          } catch(InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    };

    Thread thread = new Thread(runnable);
    thread.start();
  }
}