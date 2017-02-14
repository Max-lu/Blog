package cn.maxlu.cookie;

/**
 * Created by max.lu on 2016/2/24.
 */
public class CookieSpec {
    private String name;
    private Integer maxAge;

    CookieSpec(String name) {
        this.name = name;
    }
    public static CookieSpec newInstance(String name) {
        return new CookieSpec(name);
    }

    public String getName() {
        return name;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public CookieSpec setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
        return this;
    }
}
