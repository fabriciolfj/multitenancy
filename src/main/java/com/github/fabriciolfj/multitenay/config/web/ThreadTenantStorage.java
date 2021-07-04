package com.github.fabriciolfj.multitenay.config.web;

public class ThreadTenantStorage {

    private static ThreadLocal<String> currentTenant = new ThreadLocal<>();

    public static void setTenantId(final String tenantId) {
        currentTenant.set(tenantId);
    }

    public static String getTenantId() {
        return currentTenant.get();
    }

    public static void clear() {
        currentTenant.remove();
    }
}
