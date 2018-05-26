package crud;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Game {
    private long appid;
    private String name;
    private double price;
    private byte gamepadSupport;

    @Id
    @Column(name = "appid", nullable = false)
    public long getAppid() {
        return appid;
    }

    public void setAppid(long appid) {
        this.appid = appid;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "gamepadSupport", nullable = false)
    public byte getGamepadSupport() {
        return gamepadSupport;
    }

    public void setGamepadSupport(byte gamepadSupport) {
        this.gamepadSupport = gamepadSupport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (appid != game.appid) return false;
        if (Double.compare(game.price, price) != 0) return false;
        if (gamepadSupport != game.gamepadSupport) return false;
        if (name != null ? !name.equals(game.name) : game.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (appid ^ (appid >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) gamepadSupport;
        return result;
    }
}
