//самая простая реализация
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}

//ленивая инициализация, не потокобезопасная
public class Singleton {
    private static Singleton INSTANCE;
  
    private Singleton() {}
  
    public static Singleton getInstance() {
      if (INSTANCE == null) {
        INSTANCE = new Singleton();
      }
      return INSTANCE;
    }
  }

 //ленивая инициализация, потокобезопасная
  public class Singleton {
    private static Singleton INSTANCE;
  
    private Singleton() {
    }
  
    public static synchronized Singleton getInstance() {
      if (INSTANCE == null) {
        INSTANCE = new Singleton();
      }
      return INSTANCE;
    }
  }
