package com.example.ventas_nueva.app;

import android.app.Application;

import com.example.ventas_nueva.Dao.ClienteDAO;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MyApplication extends Application {
    public static AtomicInteger BoardId = new AtomicInteger();
    public static AtomicInteger ClienteId = new AtomicInteger();
    public void onCreate(){
        super.onCreate();
        setUpRealConfig();
        Realm realm = Realm.getDefaultInstance();
        ClienteId = getIdbyTable(realm, ClienteDAO.class);
        realm.close();
    }
    private void setUpRealConfig(){
        Realm.init(getApplicationContext());
        RealmConfiguration configuration = new RealmConfiguration.Builder().
                deleteRealmIfMigrationNeeded().
                build();
        Realm.setDefaultConfiguration(configuration);
    }
    private <T extends RealmObject> AtomicInteger getIdbyTable(Realm realm, Class<T>anyClass){
        RealmResults<T> results= realm.where(anyClass).findAll();
        return (results.size()>0) ? new AtomicInteger(results.max("id").intValue()):new AtomicInteger();
    }
}
