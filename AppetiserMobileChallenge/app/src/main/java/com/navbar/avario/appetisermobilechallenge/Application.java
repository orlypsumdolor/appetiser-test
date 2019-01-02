package com.navbar.avario.appetisermobilechallenge;

import com.facebook.stetho.Stetho;
import com.orm.SchemaGenerator;
import com.orm.SugarApp;
import com.orm.SugarContext;
import com.orm.SugarDb;

/**
 * @author: orly
 * @date: 12/27/2018
 * @department: Android
 */
public class Application extends SugarApp {

  @Override
  public void onCreate() {
    super.onCreate();

    Stetho.initializeWithDefaults(this);
    SugarContext.init(this);
    SchemaGenerator schemaGenerator = new SchemaGenerator(this);
    schemaGenerator.createDatabase(new SugarDb(this).getDB());
  }
}
