public interface Location {
    class Data {
        int x = 0;
        int y = 0;

    }
    Data DATA = new Data();
    default int setX(int x) {
        DATA.x = x;
        return x;
    }

    default int setY(int y) {
        DATA.y = y;
        return y;
    }

    default int getX() {
        return DATA.x;
    }

    default int getY() {
        return DATA.y;
    }
}
