public class Land {
    Entity entity;
    private int x, y;
    @Override
    public String toString() {
        if (entity != null) {
            return entity.toString();
        }
        return "\uD83C\uDF44";
    }


    public Land(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x + 2;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void placeEntity(Entity entity) {
        this.entity = entity;
    }

    public void removeEntity() {
        this.entity = null;
    }

    String locationRepresentation(){
        return x + "," + y + " ";
    }
}