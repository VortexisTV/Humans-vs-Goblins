import java.util.ArrayList;

public class GameWorld {
    ArrayList<Land> lands;
    int worldSize;

    Human player;
    ArrayList<Goblin> goblins;

    public void resetPlayerPosition() {
        // Assuming the starting position is (0,0)
        player.setX(0);
        player.setY(0);

        // Ensure the land reflects the player's new position
        lands.forEach(land -> {
            if (land.getX() == player.getX() && land.getY() == player.getY()) {
                land.placeEntity(player);
            } else if (land.entity instanceof Human) {
                land.removeEntity(); // Remove the player from their previous location
            }
        });
    }


    void movePlayer(String direction) {
        boolean moved = player.move(direction, player, worldSize);

        if (!moved) {
            System.out.println("Cannot move in that direction or invalid key.");
            return;
        }

        // Remove the player from the current location
        lands.forEach(land -> {
            if (land.entity instanceof Human) { // Check if the entity is the player
                land.removeEntity(); // Remove only if it's the player
            }
        });

        lands.forEach(land -> {
            if (land.getX() == player.getX() && land.getY() == player.getY()){
                if (land.entity instanceof Goblin) {
                    boolean result = Actions.combat(player, land.entity);
                    if (result) {
                        land.removeEntity();
                        land.placeEntity(player);
                    } else {
                        resetPlayerPosition();
                        System.out.println("You died. Try again.");
                    }
                } else {
                    land.placeEntity(player);
                }
            } else if (land.entity instanceof Human) {
                land.removeEntity();
            }
        });
    }


    public GameWorld(int worldSize) {
        player = new Human();
        this.worldSize = worldSize;
        lands = new ArrayList<>();
        goblins = new ArrayList<>();

        for (int i = 0; i < worldSize; i++) {
            for (int j = 0; j < worldSize; j++) {
                Land land = new Land(j, i);
                if (i == worldSize - 1) {
                    Goblin goblin = new Goblin();
                    goblins.add(goblin); // Add goblin to the list
                    land.placeEntity(goblin);
                }
                lands.add(land);
            }

        }
        if (!lands.isEmpty()) {
            lands.get(0).placeEntity(player);
        }

    }

    public String toString () {
        return lands.toString();
    }

    void landIteration ( boolean isTreeRep){
        int counter = 0;
        for (Land land : lands) {
            System.out.print(isTreeRep ? land : land.locationRepresentation() + " ");
            counter++;
            if (counter == worldSize) {
                System.out.println();
                counter = 0;
            }
        }
    }


    void displayWorld () {
        landIteration(true);
    }

    void displayLocationCoords () {
        landIteration(false);
    }

}