package com.Test;

// Por Cintia García Ruiz 2018

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AlmacenTest.class, ArticuloTest.class, StockTest.class })
public class AllTests {

}
