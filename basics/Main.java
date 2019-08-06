import java.util.*;
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

  // pluralize
  // accepts a word and a number and returns a string with the word pluralized with an “s” if the number is zero, or greater than one.
  public static String pluralize(String word, int count) {
    if (count == 0 || count > 1) {
      return word + "s";
    } else {
      return word;
    }
  }

  // flipNHeads
  // accepts an integer n and flips coins until n heads are flipped in a row. 
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

  // Clock - 1st implementation
  // using Thread & Runnable
  // constantly print out the current time to the console, second by second.
  public static void clock() {
    int timeInterval = 1000;

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

  // timerTaskClock - 2nd implementation
  // using TimerTask & Timer
  // constantly print out the current time to the console, second by second.
  public static void timerTaskClock() {
    int delay = 0;
    int period = 1000;

    TimerTask timerTask = new TimerTask() {
      public void run() {
        LocalDateTime now = LocalDateTime.now();
        String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        System.out.println(time);
      }
    };

    Timer timer = new Timer("Timer");
    timer.scheduleAtFixedRate(timerTask, delay, period);
  }
}