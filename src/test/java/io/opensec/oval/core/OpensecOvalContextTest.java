package io.opensec.oval.core;

import io.opensec.oval.core.OpensecOvalContext;

import org.junit.Test;



/**
 */
public class OpensecOvalContextTest
{

    @Test
    public void testGetProperty()
    {
        OpensecOvalContext  context = OpensecOvalContext.basic();

        System.out.println( "===== context properties =====" );
        for (String  key : context.getPropertyKeys()) {
            String  value = context.getProperty( key );
            System.out.println( "key=" + key + ", value=" + value );
        }
    }

}
