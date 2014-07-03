package com.dslplatform.test;

import com.dslplatform.client.Bootstrap;
import com.dslplatform.patterns.ServiceLocator;
import com.dslplatform.test.M.A;
import com.dslplatform.test.M.repositories.ARepository;

import java.io.IOException;

public class Main {

    public static void main(String ... argv ) throws IOException {

        ServiceLocator locator = Bootstrap.init(Main.class.getResourceAsStream("/project.props"));
        doSomeA(locator);
    }

    static void doSomeA(ServiceLocator locator) throws IOException {
        ARepository ar = locator.resolve(ARepository.class);
        String[] ones = {"one", "two", "three"};

        for ( String string : ones) {
            A a = new A();
            a.create();
        }
    }
}
