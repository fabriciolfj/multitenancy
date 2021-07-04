package com.github.fabriciolfj.multitenay.config.datasource;

import com.github.fabriciolfj.multitenay.config.web.ThreadTenantStorage;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class TenantRoutingDataSource extends AbstractRoutingDataSource {

    /*
    O AbstractRoutingDataSource chamará determineCurrentLookupKey () sempre que um cliente solicitar uma conexão.
    O inquilino atual está disponível em ThreadTenantStorage, portanto, o método determineCurrentLookupKey () retorna este inquilino atual.
    Dessa forma, TenantRoutingDataSource encontrará o DataSource deste inquilino e retornará uma conexão com esta fonte de dados automaticamente.
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return ThreadTenantStorage.getTenantId();
    }
}
