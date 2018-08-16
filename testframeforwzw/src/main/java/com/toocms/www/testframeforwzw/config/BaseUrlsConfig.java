package com.toocms.www.testframeforwzw.config;

public class BaseUrlsConfig {
    private String baseUrl = "";
    private String updateUrl = "";
    private String testBaseUrl = "";
    private String testUpdateUrl = "";

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public String getTestBaseUrl() {
        return testBaseUrl;
    }

    public String getTestUpdateUrl() {
        return testUpdateUrl;
    }

    private BaseUrlsConfig() {
    }

    private BaseUrlsConfig(BaseUrlsConfig baseUrlsConfig) {
        this.baseUrl = baseUrlsConfig.baseUrl;
        this.updateUrl = baseUrlsConfig.updateUrl;
        this.testBaseUrl = baseUrlsConfig.testBaseUrl;
        this.testUpdateUrl = baseUrlsConfig.testUpdateUrl;
    }

    public static class Builder {
        private BaseUrlsConfig mBaseUrlsConfig;

        public Builder() {
            mBaseUrlsConfig = new BaseUrlsConfig();
        }

        public Builder baseUrl(String baseUrl) {
            mBaseUrlsConfig.baseUrl = baseUrl;
            return this;
        }

        public Builder updateUrl(String updateUrl) {
            mBaseUrlsConfig.updateUrl = updateUrl;
            return this;
        }

        public Builder testBaseUrl(String testBaseUrl) {
            mBaseUrlsConfig.testBaseUrl = testBaseUrl;
            return this;
        }

        public Builder testUpdateUrl(String testUpdateUrl) {
            mBaseUrlsConfig.testUpdateUrl = testUpdateUrl;
            return this;
        }

        public BaseUrlsConfig build() {
            return new BaseUrlsConfig(mBaseUrlsConfig);
        }
    }
}
