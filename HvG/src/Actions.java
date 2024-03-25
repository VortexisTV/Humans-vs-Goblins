import java.util.Random;

public interface Actions {
    default boolean move(String direction, Location location, int bounds) {
        if (direction.equals("w")) {
            location.setY(location.getY() - 1);
        } else if (direction.equals("s")) {
            location.setY(location.getY() + 1);
        } else if (direction.equals("a")) {
            location.setX(location.getX() - 1);
        } else if (direction.equals("d")) {
            location.setX(location.getX() + 1);
        } else return false;

        if (location.getX() < 0 || location.getX() >= bounds || location.getY() < 0 || location.getY() >= bounds)
            return false;


        if (location.getX() < 0) {
            location.setX(0);
        } else if (location.getX() >= bounds) {
            location.setX(bounds - 1);
        }
        return true;
    }

    static boolean combat(Entity player, Entity goblin) {
        Random random = new Random();
        double minDamage = 50.0; // Minimum damage value
        double maxDamage = 150.0; // Maximum damage value

        boolean playerWins = random.nextBoolean();
        double damage = minDamage + (maxDamage - minDamage) * random.nextDouble();

        if (playerWins) {
            System.out.println(String.format("The human pummeled the goblin with %.2f. It's very effective!", damage));
            System.out.println("Player wins the combat!");


        } else {
            System.out.println(String.format("The goblin slashed the human with %.2f. It's very effective!", damage));
            System.out.println("Player loses the combat.");

        }
        return playerWins;
    }

}
