public class Action {
    public void Move(String name, int distance, int maxDistance, String[] moveTypeWords)
    {
        if (maxDistance == 0) {
            System.out.println(name + moveTypeWords[0]);
        } else if (distance > maxDistance ) {
            System.out.println(name +  moveTypeWords[1] + String.valueOf(maxDistance) +
                    " м из " + String.valueOf(distance) + " м");
        }
        else
            System.out.println (name + moveTypeWords[1] + String.valueOf(distance) + " м");
    }
}
