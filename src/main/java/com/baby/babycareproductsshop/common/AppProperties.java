package com.baby.babycareproductsshop.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "app") //
public class AppProperties {

    private final Jwt jwt = new Jwt();

    @Getter
    @Setter
    public static class Jwt {
        private String secret;
        private String headerSchemeName;
        private String tokenType;
        private long accessTokenExpiry;
        private long refreshTokenExpiry;
        private int refreshCookieMaxAge;

        public void setRefreshTokenExpiry(long refreshTokenExpiry) {
            this.refreshTokenExpiry = refreshTokenExpiry;
            refreshCookieMaxAge = (int) refreshTokenExpiry / 1000;
        }
    }
}
