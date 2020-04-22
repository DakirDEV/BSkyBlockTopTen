package net.hexxcraft.bskyblocktopten.objects;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class TopTenSign {
    private int place;
    private World world;
    private double x;
    private double y;
    private double z;

    public TopTenSign(int place, World world, double x, double y, double z) {
        this.place = place;
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getPlace() {
        return place;
    }

    public World getWorld() {
        return world;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Location getLocation() {
        return new Location(world, x, y, z);
    }

    public String toString() {
        return place + ";" + world.getName() + ";" + x + ";" + y + ";" + z;
    }

    public static TopTenSign valueOf(String signString) {
        String[] args = signString.split(";");
        int place = Integer.parseInt(args[0]);
        World world = Bukkit.getWorld(args[1]);
        double x = Double.parseDouble(args[2]);
        double y = Double.parseDouble(args[3]);
        double z = Double.parseDouble(args[4]);
        return new TopTenSign(place, world, x, y, z);
    }
}
