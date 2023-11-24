

public abstract class Animal {
   private String name;
   private int maxRunDistance;
   private int maxSwimDistance;
   public Animal(String name){
      this.name = name;
   }

   public void setMaxRunDistance(int distance)
   {
      maxRunDistance = distance;
   }

   public void setMaxSwimDistance(int distance)
   {
      maxSwimDistance = distance;
   }
   public void run (int distance)
   {
      String[] runWords = {" не может бегать"," пробежал "};
      Action runAction = new Action();
      runAction.Move(name, distance, maxRunDistance, runWords);
   }

   public void swim (int distance)
   {
      String[] swimWords = {" не может плавать"," проплыл "};
      Action swimAction = new Action();
      swimAction.Move(name, distance, maxSwimDistance, swimWords);
   }
}
