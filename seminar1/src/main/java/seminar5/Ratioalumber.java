package seminar5;

import java.util.Objects;

/**
 *  Rep Invariant: denuminator > 0, ration number will be in its reduced form gcd = 1
 *  abstract function: AF(numnetor, denuminator) = numenator / denuminator
 *  Safety From Rep exposure: checkRepresentation()
 */
public class Ratioalumber {
    private final int numenator;
    private final int denuminator;

    public Ratioalumber(int denuminator, int numenator) {
        if (denuminator == 0) throw new IllegalArgumentException("Shemovida nuli");
        if (denuminator < 0) {
            denuminator *= -1;
            numenator *= -1;
        }
        int g = gcd(Math.abs(numenator), Math.abs(denuminator));
        denuminator /= g;
        numenator /= g;
        if (numenator == 0) {
            this.numenator = 0;
            this.denuminator = 1;
        } else {
            this.denuminator = denuminator;
            this.numenator = numenator;
        }
        checkRepresentation();
    }

    private void checkRepresentation() {
        assert denuminator > 0;
        assert gcd(Math.abs(numenator), denuminator) == 1;
    }

    private int gcd(int a, int b) {
        return b == 0  ? a : gcd(b, a % b);
    }

    public Ratioalumber add(Ratioalumber r) {
        int n = numenator * r.denuminator + denuminator * r.numenator;
        int d = denuminator * r.denuminator;
        return new Ratioalumber(n, d);
    }

    public Ratioalumber subtract(Ratioalumber r) {
        int n = numenator * r.denuminator - denuminator * r.numenator;
        int d = denuminator * r.denuminator;
        return new Ratioalumber(n, d);
    }

    public Ratioalumber divide(Ratioalumber r) {
        int n = numenator * r.denuminator;
        int d = denuminator * r.numenator;
        return new Ratioalumber(n, d);
    }

    public Ratioalumber multiply(Ratioalumber r) {
        int n = numenator * r.numenator;
        int d = denuminator * r.denuminator;
        return new Ratioalumber(n, d);
    }
    @Override
    public String toString() {
        return numenator + "/" + denuminator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ratioalumber r)) return false;
        return (r.numenator == numenator) && (r.denuminator == denuminator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numenator, denuminator);
    }


}
