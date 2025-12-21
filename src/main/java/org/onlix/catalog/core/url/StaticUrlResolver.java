package org.onlix.catalog.core.url;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StaticUrlResolver {

    private final String baseUrl;

    public StaticUrlResolver(@Value("${app.static.base-url}") String baseUrl) {
        this.baseUrl = stripTrailingSlash(baseUrl);
    }

    public String resolve(String path) {
        if (path == null || path.isBlank()) return null;
        if (path.startsWith("http://") || path.startsWith("https://")) return path;

        String p = path.startsWith("/") ? path : "/" + path;
        return baseUrl + p;
    }

    private String stripTrailingSlash(String url) {
        return url.endsWith("/") ? url.substring(0, url.length() - 1) : url;
    }
}
