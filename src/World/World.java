package World;

import java.util.concurrent.ConcurrentLinkedQueue;

public class World {

    private static ConcurrentLinkedQueue<Tile> tiles = new ConcurrentLinkedQueue<Tile>();

    public static void update(){
        tiles.stream().forEach(tile -> tile.update());
    }
    public static void render(){
        tiles.stream().forEach(tile -> tile.render());
    }
    public static void addTile(Tile go){
        tiles.offer(go);
    }

}
