package crud;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {
    private long steamid;
    private String nickname;
    private byte vacBanned;
    private double accountValue;

    public Player(long steamid, String nickname, byte vacBanned, double accountValue) {
        this.steamid = steamid;
        this.nickname = nickname;
        this.vacBanned = vacBanned;
        this.accountValue = accountValue;
    }

    public Player() {
    }

    @Id
    @Column(name = "steamid", nullable = false)
    public long getSteamid() {
        return steamid;
    }

    public void setSteamid(long steamid) {
        this.steamid = steamid;
    }

    @Basic
    @Column(name = "nickname", nullable = false, length = 32)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "vacBanned", nullable = false)
    public byte getVacBanned() {
        return vacBanned;
    }

    public void setVacBanned(byte vacBanned) {
        this.vacBanned = vacBanned;
    }

    @Basic
    @Column(name = "accountValue", nullable = false, precision = 0)
    public double getAccountValue() {
        return accountValue;
    }

    public void setAccountValue(double accountValue) {
        this.accountValue = accountValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (steamid != player.steamid) return false;
        if (vacBanned != player.vacBanned) return false;
        if (Double.compare(player.accountValue, accountValue) != 0) return false;
        if (nickname != null ? !nickname.equals(player.nickname) : player.nickname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (steamid ^ (steamid >>> 32));
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (int) vacBanned;
        temp = Double.doubleToLongBits(accountValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
